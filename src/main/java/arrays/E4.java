package arrays;

import java.util.Arrays;

/**
 * Write a method to decide if two strings are anagrams or not.
 * 
 * @author Lucas L.
 *
 */
public class E4 {

	/**
	 * Returns whether the two Strings are anagrams or not
	 * 
	 * @param str1
	 *            first String
	 * @param str2
	 *            second String
	 * @return true if the two Strings are anagrams or not. Returns false
	 *         otherwise.
	 */
	public static boolean areAnagrams(String str1, String str2) {
		char[] str1Chars = str1.toCharArray();
		char[] str2Chars = str2.toCharArray();

		Arrays.sort(str1Chars);
		Arrays.sort(str2Chars);

		return Arrays.equals(str1Chars, str2Chars);
	}
}
