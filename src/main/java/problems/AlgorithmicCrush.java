package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You are given a list of size , initialized with zeroes. You have to perform  operations on the list and output the maximum of final values of all the  elements in the list. For every operation, you are given three integers ,  and  and you have to add value  to all the elements ranging from index  to (both inclusive).
 * <p/>
 * Input Format
 * First line will contain two integers  and  separated by a single space.
 * Next  lines will contain three integers ,  and  separated by a single space.
 * Numbers in list are numbered from  to .
 * <p/>
 * Output Format
 * <p/>
 * A single line containing maximum value in the updated list.
 * <p/>
 * <p/>
 * Sample Input #00
 * <p/>
 * 5 3
 * <p/>
 * 1 2 100
 * <p/>
 * 2 5 100
 * <p/>
 * 3 4 100
 * <p/>
 * <p/>
 * Sample Output #00
 * <p/>
 * 200
 * <p/>
 * Explanation
 * <p/>
 * After first update list will be 100 100 0 0 0.
 * <p/>
 * After second update list will be 100 200 100 100 100.
 * <p/>
 * After third update list will be 100 200 200 200 100.
 * <p/>
 * So the required answer will be 200.
 */
public class AlgorithmicCrush {

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //7542539201
        long[] arr = new long[n + 1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();

            arr[a] += k;
            if (b < n) {
                arr[b + 1] -= k;
            }
        }

        long max = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(max);
    }
}
