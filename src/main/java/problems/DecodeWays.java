package problems;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1
 * 
 * 'B' -> 2
 * 
 * ...
 * 
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * 
 * @author lucas
 *
 */
public class DecodeWays {

	private static boolean isValid(String s) {
		int num = Integer.parseInt(s);
		return (num >= 1 && num <= 26);
	}

	private static int solve(String message, int start, int lenCount) {
		if (lenCount == message.length()) {
			return 1;
		} else {
			String tmp;
			int result = 0;

			// Take only the next
			tmp = "" + message.charAt(start);
			result = solve(message, start + 1, lenCount + 1);

			if (start < message.length() - 1) {
				tmp = "" + message.charAt(start) + message.charAt(start + 1);
				if (isValid(tmp)) {
					// Take the next two
					result += solve(message, start + 2, lenCount + 2);
				}
			}

			return result;
		}
	}

	public static int solve(String message) {
		return solve(message, 0, 0);
	}

	public static void main(String[] args) {

		// 1 - 2 - 1 - 1
		// 12 - 1 - 1
		// 1 - 21 - 1
		// 1 - 2 - 11
		// 12 - 11
		String message = "1211";
		System.out.println(solve(message));
	}

}
