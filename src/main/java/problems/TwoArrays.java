package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * You are given two integer arrays, A and B, each containing N integers. The
 * size of the array is less than or equal to 1000. You are free to permute the
 * order of the elements in the arrays.
 * 
 * Now here's the real question: Is there an permutation A', B' possible of A
 * and B, such that, A'i+B'i ≥ K for all i, where A'i denotes the ith element in
 * the array A' and B'i denotes ith element in the array B'.
 * 
 * 
 * Input Format
 * 
 * The first line contains an integer, T, the number of test-cases. T test cases
 * follow. Each test case has the following format:
 * 
 * The first line contains two integers, N and K. The second line contains N
 * space separated integers, denoting array A. The third line describes array B
 * in a same format.
 * 
 * Output Format
 * 
 * For each test case, if such an arrangement exists, output "YES", otherwise
 * "NO" (without quotes).
 * 
 * 
 * Constraints 1 <= T <= 10
 * 
 * 1 <= N <= 1000
 * 
 * 1 <= K <= 10^9
 * 
 * 0 <= Ai, Bi ≤ 10^9
 * 
 * 
 * 
 * Sample Input
 * 
 * 2
 * 
 * 3 10
 * 
 * 2 1 3
 * 
 * 7 8 9
 * 
 * 4 5
 * 
 * 1 2 2 1
 * 
 * 3 3 3 4
 * 
 * Sample Output
 * 
 * YES
 * 
 * NO
 * 
 * 
 * Explanation
 * 
 * The first input has 3 elements in Array A and Array B, we see that the one of
 * the arrangements, 3 2 1 and 7 8 9 has each pair of elements (3+7, 2 + 8 and 9
 * + 1) summing upto 10 and hence the answer is "YES".
 * 
 * The second input has array B with three 3s. So, we need at least three
 * numbers in A that are greater than 1. As this is not the case, the answer is
 * "NO".
 * 
 * 
 * @author lucas
 *
 */
public class TwoArrays {

	private static void print(Integer[] a) {
		int n = a.length;

		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}

	private static String solve(int n, int k, Integer[] a, Integer[] b) {

		// Sort a ascending
		Arrays.sort(a);
		
		// Sort b descending
		Arrays.sort(b,Collections.reverseOrder());
		
		for (int i=0; i<n; i++) {
			if (a[i]+b[i] < k) {
				return "NO";
			}
		}

		return "YES";
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner scanner = new Scanner(System.in);

		int tests = scanner.nextInt();

		for (int t = 0; t < tests; t++) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			Integer[] a = new Integer[n];
			Integer[] b = new Integer[n];

			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			for (int i = 0; i < n; i++) {
				b[i] = scanner.nextInt();
			}

			System.out.println(solve(n, k, a, b));
		}
	}
}
