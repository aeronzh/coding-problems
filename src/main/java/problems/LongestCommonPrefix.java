package problems;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author lucas
 *
 */
public class LongestCommonPrefix {

	private static String prefix(String[] strs) {
		String min = strs[0];
		for (String str : strs) {
			if (str.length() < min.length()) {
				min = str;
			}
		}

		String prefix = min;
		int index = 0;
		for (int i = 0; i < strs.length; i++) {
			String word = strs[i];
			index = 0;
			while (index<prefix.length() && prefix.charAt(index) == word.charAt(index)) {
				index++;
			}
			prefix = prefix.substring(0, index);
		}

		return prefix;
	}

	public static void main(String[] args) {
		System.out.println(prefix(new String[] { "aaa", "aaabc", "aadax", "aaaaddd", "aaafk" }));
	}

}
