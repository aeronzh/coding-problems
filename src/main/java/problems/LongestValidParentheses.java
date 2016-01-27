package problems;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2. Another example is ")()())", where the longest valid parentheses
 * substring is "()()", which has length = 4.
 * 
 * @author lucas
 *
 */
public class LongestValidParentheses {

	public static int solve(String str) {
		int open = 0;
		int closed = 0;
		char[] chars = str.toCharArray();
		int max = 0;

		int count = 0;
		for (char c : chars) {
			if (c == '(') {
				open++;
			} else {
				closed++;
			}

			count++;
			if (open == closed) {
				max = Math.max(count, max);
			} else if (closed > open) {
				count = 0;
				open = 0;
				closed = 0;
			} else if (open > closed) {
				int temp = Math.max(count, max) - (open - closed);
				max = Math.max(max, temp);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solve(")()())()()()"));

	}

}
