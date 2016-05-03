package problems;

public class NumberOfIncreasingSubsequences {
	private static int solve(int[] a) {
		int n = a.length;

		// dp[i][j] = number of increasing subsequences of length i that end at element a[j]
		int[][] dp = new int[n + 1][n];

		for (int j = 0; j < n; j++) {
			dp[0][j] = 0;
			dp[1][j] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n; j++) {

				for (int k = 0; k < j; k++) {
					if (a[k] < a[j]) {
						dp[i][j] = dp[i][j] + dp[i - 1][k];
					}
				}

			}
		}

		int total = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				total += dp[i][j];
			}
		}

		return total;
	}

	public static void main(String[] args) {
		System.out.println(solve(new int[] { 1, 3, 2, 4 }));

		// 1, 3, 2, 4, 
		// 13, 12, 14, 34, 24
		// 134, 124
		// = 11
	}

}
