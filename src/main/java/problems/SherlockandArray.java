package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Watson gives Sherlock an array A of length N. Then he asks him to determine if there exists an element in the array such that the sum of
 * the elements on its left is equal to the sum of the elements on its right. If there are no elements to the left/right, then the sum is considered to be zero.
 * Formally, find an i, such that, A1+A2...Ai-1 =Ai+1+Ai+2...AN.
 * <p/>
 * Input Format
 * The first line contains T, the number of test cases. For each test case, the first line contains N, the number of elements in the array A. The second line for each test case contains N
 * space-separated integers, denoting the array A.
 * <p/>
 * Output Format
 * For each test case print YES if there exists an element in the array, such that the sum of the elements on its left is equal to the sum of the elements on its right; otherwise print NO.
 */
public class SherlockandArray {

    private static String solve(int[] a) {
        int n = a.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = a[0];
        for (int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1]+a[i];
        }

        for (int i=0; i<n; i++) {

            int left = 0;
            if (i>0) {
                left = prefixSum[i - 1];
            }

            int right = 0;
            if (i<n-1) {
                right = prefixSum[n - 1] - prefixSum[i];
            }

            if (left == right) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println(solve(a));
        }
    }
}
