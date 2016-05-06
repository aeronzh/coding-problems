package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * John Watson performs an operation called Right Circular Rotation on an integer array [a0, a1... an-1].
 * Right Circular Rotation transforms the array from [a0, a1... an-1] to [an-, a0, a1... an-2]
 * <p/>
 * He performs the operation K times and tests Sherlock's ability to identify the element at a particular position in the array. He asks Q
 * queries. Each query consists of one integer, idx , for which you have to print the element at index idx in the rotated array, i.e. a
 * <p/>
 * Input Format
 * <p/>
 * The first line consists of three integers, N, K, Q separated by a single space.
 * The next line contains N space-separated integers which indicate the elements of the array A
 * <p/>
 * <p/>
 * Each of the next Q lines contains one integer per line denoting idx.
 * <p/>
 * Output Format
 * <p/>
 * For each query, print the value at index idx in the updated array separated by newline.
 * <p/>
 * <p/>
 * Sample input
 * <p/>
 * 3 2 3
 * <p/>
 * 1 2 3
 * <p/>
 * 0
 * <p/>
 * 1
 * <p/>
 * 2
 * <p/>
 * <p/>
 * <p/>
 * Sample output
 * <p/>
 * 2
 * <p/>
 * 3
 * <p/>
 * 1
 */
public class SherlockAndWatson {

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void reverse(int[] a, int from, int to) {
        int start = from;
        int end = (to + 1 - from) / 2;

        for (int i = 0; i < end; i++) {
            int tmp = a[to - i];
            a[to - i] = a[start + i];
            a[start + i] = tmp;
        }
    }

    private static void rotate(int[] a, int k) {
        int n = a.length;
        k = k % n;

        // 1 2 3 4 5
        // 4 5 1 2 3

        // 5 4 3 2 1
        // 4 5
        if (k > 0) {
            reverse(a, 0, a.length - 1);
            reverse(a, 0, k - 1);
            reverse(a, k, a.length - 1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        rotate(a, k);

        for (int i = 0; i < q; i++) {
            int idx = scanner.nextInt();
            System.out.println(a[idx]);
        }

    }
}
