package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/separate-the-numbers
public class SeparateTheNumbers {

	/**
	 * Convert String to int
	 */
	private static long strToLong(String str) {
		long ans = 0;

		double d = str.length()-1;
		for (int i = 0; i < str.length(); i++) {
			long digit = (long) (str.charAt(i) - '0');
			if (digit != 0l) {
				long pow = (long) Math.pow(10, d);
				ans += digit * pow;
			}
			d--;
		}

		return ans;
	}

	// 99100
	private static long solve(String str, int startIdx, long prevNum, long diff) {
		if (str.length() == 1) {
			return -1;
		}

		if (startIdx == str.length() && diff == 1) {
			return prevNum;
		} else {

			if (startIdx == str.length() || str.charAt(startIdx) == '0') {
				return -1;
			}

			for (int len = 1; len <= str.length() - startIdx; len++) {
				String nextSubStr = str.substring(startIdx, startIdx + len);
				long next = strToLong(nextSubStr);

				long result = -1;
				if (next - prevNum == 1 || startIdx == 0) {
					//System.out.println("Trying next= '" + next + "' and prev= '" + prevNum + "'");
					result = solve(str, startIdx + len, next, next - prevNum);
				}

				if (result > 0) {
					return next;
				}
			}

			return -1;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		int queries = in.nextInt();

		for (int q = 0; q < queries; q++) {
			String str = in.next();
			long res = solve(str, 0, 0, 0);
			System.out.println(res > 0 ? "YES " + res : "NO");
		}
	}

}
