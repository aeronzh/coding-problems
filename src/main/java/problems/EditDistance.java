package problems;

/**
 * From Wiki:
 * 
 * In computer science, edit distance is a way of quantifying how dissimilar two
 * strings (e.g., words) are to one another by counting the minimum number of
 * operations required to transform one string into the other.
 * 
 * There are three operations permitted on a word: replace, delete, insert. For
 * example, the edit distance between "a" and "b" is 1, the edit distance
 * between "abc" and "def" is 3. This post analyzes how to calculate edit
 * distance by using dynamic programming.
 * 
 * @author lucas
 *
 */
public class EditDistance {

	/**
	 * Let dp[i][j] stands for the edit distance between two strings with length
	 * i and j, i.e., word1[0,...,i-1] and word2[0,...,j-1]. There is a relation
	 * between dp[i][j] and dp[i-1][j-1]. Let's say we transform from one string
	 * to another. The first string has length i and it's last character is "x";
	 * the second string has length j and its last character is "y". The
	 * following diagram shows the relation.
	 * 
	 * 
	 * 1. if x == y, then dp[i][j] == dp[i-1][j-1]
	 * 
	 * 
	 * 2. if x != y, and we insert y for word1, then dp[i][j] = dp[i][j-1] + 1
	 * 
	 * 
	 * 3. if x != y, and we delete x for word1, then dp[i][j] = dp[i-1][j] + 1
	 * 
	 * 
	 * 4. if x != y, and we replace x with y for word1, then dp[i][j] =
	 * dp[i-1][j-1] + 1
	 * 
	 * 
	 * 5. When x!=y, dp[i][j] is the min of the three situations.
	 * 
	 * 
	 * Initial condition: dp[i][0] = i, dp[0][j] = j
	 * 
	 * @return
	 */
	public static int solve(String a, String b) {
		int[][] dp = new int[a.length()+1][b.length()+1];

		for (int i = 0; i <= a.length(); i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= b.length(); j++) {
			dp[0][j] = j;
		}

		for (int i = 0; i < a.length(); i++) {
			char achar = a.charAt(i);
			for (int j = 0; j < b.length(); j++) {
				char bchar = b.charAt(j);

				if (achar == bchar) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int insert = dp[i + 1][j] + 1;
					int delete = dp[i][j+1] + 1;
					int replace = dp[i][j] + 1;
					
					int min = Math.min(replace, Math.min(insert, delete));
					dp[i + 1][j + 1] = min;
				}

			}
		}

		return dp[a.length()][b.length()];
	}

	public static void main(String[] args) {
		int result = solve("abc", "dfg");
		System.out.println(result);
	}

}
