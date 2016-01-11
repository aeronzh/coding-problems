package problems;

/**
 * Given two strings s and t, determine if they are isomorphic. Two strings are
 * isomorphic if the characters in s can be replaced to get t.
 * 
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 * 
 * @author lucas
 *
 */
public class IsomorphicStrings {

	private static boolean isomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		} else {
			int numRepetitionInS = 1;
			int numRepetitionInT = 1;
			int currIndex = 1;
			while (currIndex < s.length()) {
				if (s.charAt(currIndex) == s.charAt(currIndex - 1)) {
					numRepetitionInS++;
				} else {
					numRepetitionInS = 1;
				}

				if (t.charAt(currIndex) == t.charAt(currIndex - 1)) {
					numRepetitionInT++;
				} else {
					numRepetitionInT = 1;
				}

				if (numRepetitionInS != numRepetitionInT) {
					return false;
				}

				currIndex++;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(isomorphic("egg", "add"));
	}

}
