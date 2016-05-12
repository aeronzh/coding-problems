package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 * 
 * @author Lucas L.
 *
 */
public class E1 {

	/**
	 * Determine if a string has all unique characters. Using a Set data
	 * structure,
	 * 
	 * 
	 * @param str
	 *            the String to check
	 * @return true if String contains only unique characters. Return false
	 *         otherwise.
	 */
	public static boolean hasUniqueChars(String str) {
		Set<String> uniqueChars = new HashSet<String>();
		String character;
		for (char c : str.toCharArray()) {
			character = "" + c;
			if (uniqueChars.contains(character)) {
				return false;
			} else {
				uniqueChars.add(character);
			}
		}

		return true;
	}

	/**
	 * Determine if a string has all unique characters. Using an array data
	 * structure
	 * 
	 * @param str
	 *            the String to check
	 * @return true if String contains only unique characters. Return false
	 *         otherwise.
	 */
	public static boolean hasUniqueChars2(String str) {
		final int ALPHABET_COUNT = 128;
		boolean[] charOccured = new boolean[ALPHABET_COUNT];

		for (char c : str.toCharArray()) {
			if (charOccured[c]) {
				return false;
			} else {
				charOccured[c] = true;
			}
		}

		return true;
	}

	/**
	 * Determine if a string has all unique characters. Without using an
	 * additional data structure
	 * 
	 * @param str
	 *            the String to check
	 * @return true if String contains only unique characters. Return false
	 *         otherwise.
	 */
	public static boolean hasUniqueChars3(String str) {
		char[] strChars = str.toCharArray();
		Arrays.sort(strChars);

		for (int charIndex = 0; charIndex < strChars.length - 1; charIndex++) {
			if (strChars[charIndex] == strChars[charIndex + 1]) {
				return false;
			}
		}

		return true;
	}

}
