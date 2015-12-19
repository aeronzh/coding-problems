package problems;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example, given "aacecaaa", return "aaacecaaa"; given "abcd", return
 * "dcbabcd". aaacecaa aacecaaa
 * 
 * @author lucas
 *
 */
public class ShortestPalidrome {

	private static String reverse(String str) {
		char[] chars = str.toCharArray();
		char tmp;
		for (int i = 0; i < chars.length / 2; i++) {
			tmp = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = tmp;
		}

		return new String(chars);
	}

	public static String palidrome(String str) {
		String result = str;

		// reverse string
		String reverse = reverse(str);

		// take 0, 1, 2, ..n chars from the reversed front
		String sub = "";

		for (int i = 0; i < reverse.length(); i++) {
			sub = reverse.substring(0, i);
			result = sub + str;
			if (reverse(result).equals(result)) {
				break;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		System.out.println(palidrome("abcd"));

	}

}
