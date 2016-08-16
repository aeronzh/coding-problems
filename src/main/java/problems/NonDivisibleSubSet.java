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

	/**
	 * This initially appears difficult to solve in reasonable time complexity.
	 * After further thought, I think this can be done on O(n) with a few
	 * considerations. This is supposed to be an "easy" problem, so I'll provide
	 * some algorithm guidance here. For any number K, the sum of 2 values (A &
	 * B) is evenly divisible by K if the sum of the remainders of A/K + B/K is
	 * K. (There is also a special case where both A & B are evenly divisible,
	 * giving a sum of 0.) For any such remainder, there is 1 and only 1 other
	 * remainder value which will make a sum divisible by K. Example: with K of
	 * 5, remainder pairs are 1+4 & 2+3. Given the numbers with a remainder of
	 * 1, they can't be paired with ANY of the numbers with remainder 4 (and
	 * vice versa). So, for the number of values in the resultant set, choose
	 * the larger of values with remainder 1 vs. values with remainder 4. Choose
	 * the larger set of remainder 2 vs remainder 3. For the special case where
	 * remainder is 0, given the set of all values which are individually
	 * divisible by K, they can't be paired with any others. So, at most 1 value
	 * which is evenly divisible by K can be added to the result set. For even
	 * values of K, the equal remainder is simular to the 0 case. For K = 6,
	 * pairs are 1+5, 2+4, 3+3. For values with remainder 3, at most one value
	 * can be added to the result set.
	 */
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
