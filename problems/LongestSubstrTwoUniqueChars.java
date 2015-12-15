package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the longest substring that contains only two unique
 * characters. For example, given "abcbbbbcccbdddadacb", the longest substring
 * that contains 2 unique character is "bcbbbbcccb".
 * 
 * @author lucas
 *
 */
public class LongestSubstrTwoUniqueChars {

	public static String solve(String str) {
		// Start at index 0

		// Append characters and keep count of unique characters

		// If count >=3 then get the left most character x and keep only the part of the
		// current string that does not contain x (this can be done by iterating from right to left until we find an x)

		// Repeat

		char[] s = str.toCharArray();
		Set<Character> unique = new HashSet<Character>();
		int length;
		StringBuilder tmp = new StringBuilder();
		String max = "";

		for (int i = 0; i < s.length; i++) {
			// count >= 3
			if (!unique.contains(s[i]) && unique.size() == 2) {
				length = tmp.length();

				char leftChar = tmp.charAt(0);
				int j = length - 1;
				int pos = j;
				while (j >= 0) {
					if (tmp.charAt(j) == leftChar) {
						pos = j;
						break;
					}
					j--;
				}

				tmp = new StringBuilder(tmp.substring(pos + 1, length));
				unique.remove(leftChar);
			}

			if ((unique.size() < 2) || (unique.size() == 2 && unique.contains(s[i]))) {
				tmp.append(s[i]);
				unique.add(s[i]);

				if (tmp.length() > max.length()) {
					max = tmp.toString();
				}
			}

		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solve("abcbbbbcccbdddadacb"));

	}

}
