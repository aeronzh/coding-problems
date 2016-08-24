package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * We define P to be a permutation of the first N natural numbers in the range
 * [1,N]. Let pos_i denote the position of i in permutation P (please use
 * 1-based indexing).
 * 
 * P is considered to be an absolute permutation if abs(pos_i - i) = K holds
 * true for every i in [1,N].
 * 
 * Given N and K, print the lexicographically smallest absolute permutation, P;
 * if no absolute permutation exists, print -1.
 * 
 * @author lucas
 *
 */
public class AbsolutePermutation {

	private static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void solve(int n, int k) {
		// 1 2 3 4 5 6 7 8 9
		// k = 2
		// 3 4 1 2 7 8 5 6

		int[] p = new int[n];
		int num = 1;
		int i = 0;
		while (num <= n - k) {
			for (int j = 0; j < k; j++) {
				p[i] = num + k + j;
				i++;
			}

			for (int j = 0; j < k; j++) {
				p[i] = num + j;
				i++;
			}
			
			num = num + 2*k -1;
			
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = in.nextInt();
			int k = in.nextInt();
			solve(n, k);
		}

	}
}
