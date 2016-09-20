package problems;

/**
 * 
 * Given a string, a partitioning of the string is a palindrome partitioning if
 * every substring of the partition is a palindrome. For example,
 * “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
 * Determine the fewest cuts needed for palindrome partitioning of a given
 * string. For example, minimum 3 cuts are needed for “ababbbabbababa”. The
 * three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0
 * cuts are needed. If a string of length n containing all different characters,
 * then minimum n-1 cuts are needed.
 * 
 * @author lucas
 *
 */
public class PalidromicPartitioning {

	private static int partition(String s) {
		int n = s.length();
		char[] str = s.toCharArray();

		int[][] c = new int[n][n]; // c[i][j] = minimum number of cuts for substring str[i..j]
		boolean[][] p = new boolean[n][n]; // p[i][j] = true if substring str[i..j] is palidrome

		for (int i = 0; i < n; i++) {
			c[i][i] = 0;
			p[i][i] = true;
		}

		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len; i++) {
				int j = i + len;

				if (len == 2 && str[i] == str[j]) {
					p[i][j] = true;
				} else if (str[i] == str[j]) {
					p[i][j] = p[i + 1][j - 1];
				}

				if (p[i][j]) {
					c[i][j] = 0;
				} else {
					c[i][j] = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						c[i][j] = Math.min(c[i][j], c[i][k] + c[k + 1][j] + 1);
					}
				}
			}
		}

		return c[0][n - 1];
	}

	public static void main(String[] args) {
		String s = "ababbbabbababa";
		System.out.println(partition(s));
	}
}
