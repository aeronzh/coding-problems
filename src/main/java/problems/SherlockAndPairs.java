package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Sherlock is given an array of N integers (A0, A1 ... AN−1) by Watson. Now
 * Watson asks Sherlock how many different pairs of indices i and j exist such
 * that i is not equal to j but Ai is equal to Aj.
 * 
 * That is, Sherlock has to count the total number of pairs of indices (i,j)
 * where Ai=Aj AND i≠j.
 * 
 * Input Format
 * 
 * The first line contains T, the number of test cases. T test cases follow.
 * Each test case consists of two lines; the first line contains an integer N,
 * the size of array, while the next line contains N space separated integers.
 * 
 * Output Format
 * 
 * For each test case, print the required answer on a different line.
 * 
 * Constraints 1≤T≤10
 * 
 * 1≤N≤10^5
 * 
 * 1≤A[i]≤10^6
 * 
 * Sample input
 * 
 * 2
 * 
 * 3
 * 
 * 1 2 3
 * 
 * 3
 * 
 * 1 1 2
 * 
 * 
 * Sample output
 * 
 * 0
 * 
 * 2
 * 
 * Explanation
 * 
 * In the first test case, no two pair of indices exist which satisfy the given
 * condition. In the second test case as A[0] = A[1] = 1, the pairs of indices
 * (0,1) and (1,0) satisfy the given condition.
 * 
 * 
 * @author lucas
 *
 */
public class SherlockAndPairs {
	private static long solve(int[] a) {
		int n = a.length;
		long equals = 0;
		long count = 0;

		Arrays.sort(a);

		for (int i = 1; i < n; i++) {
			if (a[i] == a[i - 1]) {
				if (equals == 0) {
					equals = 2;
				} else {
					equals++;
				}
			} else {
				count += (equals * (equals - 1));
				equals = 0;
			}
		}

		if (equals > 0) {
			count += (equals * (equals - 1));
		}

		return count;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int tests = scanner.nextInt();

		for (int t = 0; t < tests; t++) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}

			System.out.println(solve(a));
		}

	}

}
