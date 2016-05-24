package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given a set, S , of n integers, print the size of a maximal subset, S', of S
 * where the sum of any 2 numbers in S' are not evenly divisible by k.
 * 
 * Input Format
 * 
 * The first line contains 2 space-separated integers, n and k, respectively.
 * The second line contains n space-separated integers (we'll refer to the ith
 * value as ai) describing the unique values of the set.
 * 
 * Constraints
 * 
 * 1<= n <= 100000
 * 
 * 1<= k <= 100
 * 
 * 1<= ai <= 1000000000
 * 
 * All of the given numbers are distinct. Output Format
 * 
 * Print the size of the largest possible subset (S').
 * 
 * @author lucas
 *
 */
public class NonDivisibleSubSet {

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static void solve(int[] a, int n, int k) {
		int[] mod = new int[k];

		for (int i = 0; i < n; i++) {
			mod[a[i] % k] = mod[a[i] % k] + 1;
		}

		// 0 1 2
		Set<Integer> set = new HashSet<Integer>();
		int mid = k / 2;
		if (k % 2 == 0) {
			mid = mid - 1;
		}

		int count = 0;
		for (int l = 1; l <= mid; l++) {
			int r = k - l;
			System.out.print(l + " vs " + r);
			if (mod[l] > mod[r]) {
				for (int i = 0; i < n; i++) {
					if (a[i] % k == l) {
						count++;
					}
				}
				System.out.println(" --> " + l);
			} else {
				for (int i = 0; i < n; i++) {
					if (a[i] % k == r) {
						count++;
					}
				}
				System.out.println(" --> " + r);
			}

		}

		if (mod[0] > 0) {
			count++;
		}

		if (k % 2 == 0 && mod[k / 2] > 0) {
			count++;
		}

		System.out.println(count);

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] a = new int[n];
		int[] c = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		solve(a, n, k);
	}

}
