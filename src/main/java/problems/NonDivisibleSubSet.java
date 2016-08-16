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
private static void solve(int[] a, int n, int k) {
		int[] mod = new int[k];

		for (int i = 0; i < n; i++) {
			mod[a[i] % k] = mod[a[i] % k] + 1;
		}
		
		int mid = k/2;
		if (k % 2 == 0) {
			mid = mid - 1;
		}

		// k = 6 --> 0 1 2 3 4 5
		// mid = 2
		// non allowed pairs: 1&5, 2&4, 3&3
		
		int size = 0;
		for (int l=1; l<=mid; l++) {
			int r = k - l;
			
			size += Math.max(mod[l], mod[r]);
		}
		
		if (mod[0] > 0) {
			size++;
		}
		
		if (k % 2 == 0 && mod[k / 2] > 0) {
			size++;
		}
		
		System.out.println(size);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		solve(a, n, k);
	}

}
