package problems;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, given s = "the sky is blue", return "blue is sky the".
 * 
 * 
 * @author lucas
 *
 */
public class ReverseWordsInString {

	private static String reverse(char[] charArray, int start, int end) {
		char tmp;
		int i = start;
		int j = end;
		while (i < j) {
			tmp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = tmp;
			i++;
			j--;
		}

		return new String(charArray);
	}

	public static String solve(String str) {
		String reversedString = reverse(str.toCharArray(), 0, str.length() - 1);
		char[] charArray = reversedString.toCharArray();
		int len = charArray.length;
		int i = 1;
		int start = 0;
		int end;
		while (i < len) {
			if (charArray[i] == ' ' || i == len - 1) {
				if (i == len - 1) {
					end = i;
				} else {
					end = i - 1;
				}

				reverse(charArray, start, end);
				start = i + 1;
			}

			i++;
		}

		return new String(charArray);
	}

	public static void main(String[] args) {
		String str = "i dont like it here";
		System.out.println(solve(str));

	}

}
