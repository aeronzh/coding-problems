package problems;

public class LongestPalidrome {

	private static String solve(String word) {
		int n = word.length();
		char[] s = word.toCharArray();

		// Define dp[i][j] ← true iff the substring s[i...j] is a palindrome, otherwise false.
		// dp[i][j] ← ( dp[i+1][j-1] and S[i] = S[j] )
		boolean[][] dp = new boolean[n][n];

		int maxLen = 1;
		int longestBegin = 0;

		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		for (int i = 0; i < n - 1; i++) {
			if (s[i] == s[i + 1]) {
				dp[i][i + 1] = true;
				longestBegin = i;
				maxLen = 2;
			}
		}

		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (s[i] == s[j] && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					longestBegin = i;
					maxLen = len;
				}
			}
		}

		return word.substring(longestBegin, longestBegin + maxLen);
	}

	public static void main(String[] args) {
		System.out.println(solve("abacdfgdcaba"));

	}

}
