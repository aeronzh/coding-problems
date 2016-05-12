package arrays;

/**
 * Design an algorithm and write code to remove the duplicate characters in a
 * string without using any additional buffer. NOTE: One or two additional
 * variables are fine. An extra copy of the array is not. FOLLOW UP: Write the
 * test cases for this method.
 * 
 * @author Lucas L.
 *
 */
public class E3 {

	/**
	 * Returns a String with removed duplicate characters.
	 * 
	 * @param str
	 *            the char[] to remove the duplicate characters from
	 * @return String with removed duplicate characters
	 */
	public static String removeDuplicateChars(char[] str) {
		int len = str.length;

		if (len < 2) {
			return new String(str);
		}

		int tail = 1;
		for (int i = 1; i < len; i++) {
			int j;
			INNER_LOOP: for (j = 0; j < tail; j++) {
				if (str[j] == str[i]) {
					break INNER_LOOP;
				}
			}

			if (j == tail) {
				// Not found
				str[tail] = str[i];
				tail++;
			}

		}

		if (tail < len) {
			str[tail] = 0;
		}

		return new String(str);
	}

	/**
	 * Returns a String with removed duplicate characters.
	 * 
	 * This algorithm uses an additional buffer.
	 * 
	 * @param str
	 *            the String to remove the duplicate characters from
	 * @return String with removed duplicate characters
	 */
	public static String removeDuplicateChars(String str) {
		StringBuilder result = new StringBuilder();

		for (int charIndex = 0; charIndex < str.length(); charIndex++) {
			boolean containsChar = false;
			INNER_LOOP: for (int charIndex2 = 0; charIndex2 < result.length(); charIndex2++) {
				if (result.charAt(charIndex2) == str.charAt(charIndex)) {
					containsChar = true;
					break INNER_LOOP;
				}
			}

			if (!containsChar) {
				result.append(str.charAt(charIndex));
			}
		}

		return result.toString();
	}

}
