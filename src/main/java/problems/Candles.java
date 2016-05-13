package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Tim is visiting his grandma for two days and is bored due to the lack of the
 * electricity over there. That's why he starts to play with grandma's colorful
 * candle collection.
 * 
 * He aligned the N candles from left to right. The ith candle from the left has
 * the height Hi and the color Ci, an integer ranged from 1 to a given K, the
 * number of colors.
 * 
 * Now he stares at the sequence of candles and wonders, how many strictly
 * increasing ( in height ) colorful subsequences are there? A subsequence is
 * considered as colorful if every of the K colors appears at least one times in
 * the subsequence.
 * 
 * As the number of subsequences fulfilling the requirement can be large, print
 * the result modulo 10^9+7.
 * 
 * Input Format
 * 
 * On the first line you will be given N and K, then N lines will follow. On the
 * ith line you will be given two integers Hi and Ci.
 * 
 * Output Format
 * 
 * Print the number of strictly increasing colorful subsequences modulo 10^9+7.
 * 
 * Constraints
 * 
 * 
 * 1≤N≤5⋅10^4
 * 
 * 1≤Ci≤K≤7
 * 
 * 1≤Hi≤5⋅10^4
 * 
 * Sample Input
 * 
 * 4 3
 * 
 * 1 1
 * 
 * 3 2
 * 
 * 2 2
 * 
 * 4 3
 * 
 * Sample Output
 * 
 * 2
 * 
 * 
 * Explanation
 * 
 * In the first sample the only two valid subsequences are (1, 2, 4) and (1, 3,
 * 4).
 * 
 * @author lucas
 *
 */
public class Candles {
	private static int solve(int[] h, int[] c, int k) {
		int n = h.length;

		// dp[i][j] = number of increasing subsequences of length i that end at element a[j]
		int[][] dp = new int[n + 1][n];

		// colors[i][j] = colors of increasing subsequence of length i that ends at element a[j]
		Set[][] colors = new HashSet[n + 1][n];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				colors[i][j] = new HashSet<Integer>();
			}
		}

		for (int j = 0; j < n; j++) {
			dp[0][j] = 0;

			dp[1][j] = 1;
			colors[1][j].add(c[j]);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n; j++) {

				for (int s = 0; s < j; s++) {
					if (h[s] < h[j]) {
						dp[i][j] = dp[i][j] + dp[i - 1][s];
						if (i==3 && j == 7) {
							System.out.print("Adding "+ colors[i - 1][s]+"("+h[s]+")" + " to " + colors[i][j] + "("+h[j]+")");
						}
						colors[i][j].addAll(colors[i - 1][s]);
						colors[i][j].add(c[j]);
						if (i==3 && j == 7) {
							System.out.println(" --> "+colors[i][j]);
						}
					}
				}

			}
		}

		int total = 0;
		int count = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				count += dp[i][j];
				if (colors[i][j].size() == k) {
					total += dp[i][j];
				}
			}
		}

		System.out.println(count);
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(colors[i][j] + " ");
			}
			System.out.println();
		}

		return total;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] h = new int[n];
		int[] c = new int[n];

		// 1 3 2 4
		// 1 2 2 3
		for (int i = 0; i < n; i++) {
			h[i] = scanner.nextInt();
			c[i] = scanner.nextInt();

		}

		System.out.println(solve(h, c, k));
	}

}
