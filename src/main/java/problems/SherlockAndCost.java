package problems;

/**
 * Array A contains the elements, A1,A2...AN. And array B contains the elements,
 * B1,B2...BN. There is a relationship between Ai and Bi, ∀ 1 ≤ i ≤ N, i.e., any
 * element Ai lies between 1 and Bi.
 * 
 * Let cost S of an array A is defined as:
 * 
 * S = Sum_(i=2..n) |a_i - a_(i-1)|
 * 
 * You have to print the largest possible value of S.
 * 
 * @author lucas
 *
 */
public class SherlockAndCost {

	private static int solve(int[] b) {
		int n = b.length;

		if (n < 2) {
			return 0;
		}

		int[][] dp = new int[n][2]; // dp[i][0] is sum up to index i when a[i]=b[i], and dp[i][1] when a[i] = 1
		dp[1][0] = Math.max(Math.abs(1 - b[1]), Math.abs(b[0] - b[1]));
		dp[1][1] = Math.max(Math.abs(1 - 1), Math.abs(b[0] - 1));

		for (int i = 2; i < n; i++) {

			// dp[i] for a[i] = b[i] is the maximum of (dp[i - 1] + |a[i-1] - b[i]| with a[i-1]=b[i-1]) and (dp[i - 1] + |a[i-1] - b[i]| with a[i-1]=1)
			dp[i][0] = Math.max(dp[i - 1][0] + Math.abs(b[i - 1] - b[i]), dp[i - 1][1] + Math.abs(1 - b[i]));

			// dp[i] for a[i] = 1 is the maximum of (dp[i - 1] + |a[i-1] - 1| with a[i-1]=b[i-1]) and (dp[i - 1] + |a[i-1] - 1| with a[i-1]=1)
			dp[i][1] = Math.max(dp[i - 1][0] + Math.abs(b[i - 1] - 1), dp[i - 1][1]);

		}

		return Math.max(dp[n - 1][0], dp[n - 1][1]);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 75, 26, 45, 72, 81, 47, 29, 97, 2, 75, 25, 82, 84, 17, 56, 32, 2, 28, 37, 57, 39, 18 };//1121
		System.out.println(solve(a));

		int[] b = new int[] { 55, 68, 31, 80, 57, 18, 34, 28, 76, 55 }; // 508
		System.out.println(solve(b));

		int[] c = { 33 }; // 0
		System.out.println(solve(c));

	}

}
