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
public class AbsolutePermutation2 {

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
		if (k==0) {
			for (int i=0; i<n; i++) {
				p[i] = i+1;
			}
			print(p);
			return;
		}
		
		if (k>0 && n % (2*k) != 0) {
            System.out.println("-1");
            return;
        }
		
		int num = 1;
		int i = 0;
		while (i < n - k) {
			// swap num with (num+k)
			for (int j = 0; j < k; j++) {
				p[i+j] = num + k + j;
				p[i + k + j] = num + j;
			}

			num += (2*k);
			i += (2*k);
		}

		print(p);

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
