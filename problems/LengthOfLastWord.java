package problems;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string. If the last
 * word does not exist, return 0.
 * 
 * @author lucas
 *
 */
public class LengthOfLastWord {

	private static int returnLength(String str) {
		int result = 0;

		int len = str.length();
		boolean word = false;
		char c;
		LOOP_CHARS: for (int i = len - 1; i >= 0; i--) {
			c = str.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				word = true;
				result++;
			} else {
				if (word) {
					break LOOP_CHARS;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String str = "Lorem Ipsum Dolor    ";
		System.out.println(returnLength(str));
	}

}
