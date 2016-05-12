package arrays;

/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (i e , �waterbottle� is a
 * rotation of �erbottlewat�).
 * 
 * @author Lucas L.
 *
 */
public class E8 {

	/**
	 * Checks if one word is a substring of another.
	 * 
	 * @param s1
	 * @param s2
	 * @return true if s1 is substring of s2
	 */
	private static boolean isSubstring(String s1, String s2) {
		return s2.indexOf(s1) != -1;
	}

	/**
	 * 
	 * Checks if s2 is a rotation of s1 using only one call to isSubstring (i e
	 * , �waterbottle� is a rotation of �erbottlewat�).
	 * 
	 * s2 + s2 = erbottlewaterbottlewat -> s1 isSubstring of (s2+s2)
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isRotation(String s1, String s2) {
		String concat = s2 + s2;
		return isSubstring(s1, concat);
	}

}
