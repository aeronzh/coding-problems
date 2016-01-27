package problems;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * 
 * @author lucas
 *
 */
public class GenerateParentheses {

	public static void solve(int n, String s, int open, int closed) {
		if (open == n && closed == n) {
			System.out.println(s);
		} else {
			if (open == closed) {
				solve(n, s + "(", open + 1, closed);
			}

			if (open > closed) {
				if (open < n) {
					solve(n, s + "(", open + 1, closed);
				}
				solve(n, s + ")", open, closed + 1);
			}
		}
	}

	public static void main(String[] args) {
		solve(2, "", 0, 0);

	}

}
