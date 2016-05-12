package arrays;

/**
 * Write code to reverse a String.
 * 
 * @author Lucas L.
 *
 */
public class E2 {

	/**
	 * Reverse a String.
	 * 
	 * @param str
	 *            the String to reverse
	 * @return the reversed String
	 */
	public static String reverseString(String str) {
		char[] strCharacters = str.toCharArray();

		int len = strCharacters.length;
		int middle = len / 2;
		char tmp;
		for (int charIndex = 0; charIndex < middle; charIndex++) {
			tmp = strCharacters[charIndex];
			strCharacters[charIndex] = strCharacters[len - charIndex - 1];
			strCharacters[len - charIndex - 1] = tmp;
		}

		return new String(strCharacters);
	}

	public static void main(String[] args) {
		String[] words = { "", "a", "abc", "abcd", "aabc", "12a3a4b", "aaaa" };
		for (String word : words) {
			System.out.println("'" + word + "' -> " + reverseString(word));
		}
	}

}
