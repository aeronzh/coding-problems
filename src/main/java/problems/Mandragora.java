package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The evil forest is guarded by N vicious mandragoras. Each ith mandragora has
 * health Hi points (1<=i<=N).
 * 
 * Garnet and her pet begin their journey through the evil forest with S=1
 * strength points and P=0 experience points. For each undefeated mandragora i,
 * she can perform either of the following actions:
 * 
 * 1. Garnet's pet eats mandragora i. This increments S by 1 and defeats
 * mandragora i.
 * 
 * 
 * 2. Garnet's pet battles mandragora i. This increases P by S * Hi experience
 * points and defeats mandragora i.
 * 
 * Each mandragora can only be defeated once, and Garnet can defeat the
 * mandragoras in any order. Given the respective health points for each
 * mandragora, can you find the maximum number of experience points she can earn
 * from defeating all N mandragoras?
 * 
 * Input Format
 * 
 * The first line contains an integer, T, denoting the number of test cases.
 * Each test case is described over two lines:
 * 
 * The first line contains a single integer, N, denoting the number of
 * mandragoras in the forest.
 * 
 * The second line contains N space-separated integers describing the respective
 * health points for the mandragoras (i.e.,H1, H2, ...,Hn).
 * 
 * @author lucas
 *
 */
public class Mandragora {

	private static long solve(int[] h, int n) {
		// 1. Goal: Increment S by eating the smallest mandragoras FIRST --> How many of those to eat??
		// 2. Eat the remaining mandragoras to increase performance

		Arrays.sort(h);

		long[] prefix = new long[n];
		prefix[0] = h[0];
		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] + h[i];
		}

		long max = prefix[0];
		for (int amount = 1; amount < n; amount++) {

			// Eat the first 'amount' mandragoras
			long s = amount + 1;

			// Fight remaining (n - amount) mandragoras
			long p = (prefix[n - 1] - prefix[amount - 1]) * s;

			max = Math.max(p, max);
		}

		return max;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = in.nextInt();
			int[] h = new int[n];
			for (int i = 0; i < n; i++) {
				h[i] = in.nextInt();
			}

			long ans = solve(h, n);
			System.out.println(ans);
		}
	}

}
