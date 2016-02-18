package problems;

/**
 * Shashank likes strings in which consecutive characters are different. For
 * example, he likes ABABA, while he doesn't like ABAA. Given a string
 * containing characters A and B only, he wants to change it into a string he
 * likes. To do this, he is allowed to delete the characters in the string.
 * 
 * Your task is to find the minimum number of required deletions.
 * 
 * @author lucas
 *
 */
public class AlternatingStrings {

	private static int solve(String str) {
		char[] chars = str.toCharArray();
		int total = 0;
		int skip = 1;
		for (int c = 1; c < chars.length; c = c + skip) {
			int i = c;
			skip = 1;
			while ((i + skip - 1) < chars.length && chars[i + skip - 1] == chars[i + skip - 2]) {
				total++;
				skip++;
			}
		}

		return total;
	}

	public static void main(String[] args) {
		String[] input = { "AAAA", "BBBBB", "ABABABAB", "BABABA", "AAABBB" };

		for (String str : input) {
			System.out.println(solve(str));
		}

	}

}
