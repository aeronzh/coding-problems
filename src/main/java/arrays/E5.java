package arrays;

/**
 * Write a method to replace all spaces in a string with �%20�.
 * 
 * @author Lucas L.
 *
 */
public class E5 {

	public static String replaceSpaces(String str) {
		StringBuilder result = new StringBuilder();

		char[] strChars = str.toCharArray();
		for (char c : strChars) {
			if (c == ' ') {
				result.append("%20");
			} else {
				result.append(c);
			}
		}

		return result.toString();
	}
}
