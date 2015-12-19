package problems;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * @author lucas
 *
 */
public class CountAndSay {

	public static String solve(int n) {
		String prev = "1";

		String result = "";
		for (int a = 0; a < n; a++) {
			int len = prev.length();
			int count = 0;
			int i = 0;
			char prevChar = prev.charAt(i);
			while (i < len) {
				while (i < len && prev.charAt(i) == prevChar) {
					count++;
					i++;
				}

				result = result + count + prevChar;

				if (i < len) {
					prevChar = prev.charAt(i);
					count = 0;
				}
			}

			prev = result;
			result = "";
		}
		return prev;
	}

	public static void main(String[] args) {
		System.out.println(solve(4));

	}

}
