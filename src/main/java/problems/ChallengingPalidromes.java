package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * s = s_a + s_b
 * 
 * s is palidromic
 * 
 * s has maximum length
 * 
 * @author lucas
 *
 */

// jdfh
// fds
// -> dfhfd
public class ChallengingPalidromes {

	public static boolean isPalidromic(String s) {
		char[] str = s.toCharArray();
		int n = str.length;
		for (int i = 0; i < n / 2; i++) {
			if (str[i] != str[n - i - 1]) {
				return false;
			}
		}

		return true;
	}

	public static String reverse(String s) {
		char[] str = s.toCharArray();
		int n = str.length;
		for (int i = 0; i < n / 2; i++) {
			char tmp = str[i];
			str[i] = str[n - i - 1];
			str[n - i - 1] = tmp;
		}

		return new String(str);
	}

	private static String longestCommonSubstr(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] l = new int[m][n];

		//		for (int i=0; i<m; i++) {
		//			l[i][0] = a.charAt(i) == b.charAt(0) ? 1 : 0;
		//		}
		//		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					l[i][j] = 1 + l[i - 1][j - 1];
				} else {
					l[i][j] = 0;
				}
			}
		}

		int max = l[0][0];
		String subStr = "";
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (l[i][j] > max) {
					max = l[i][j];

					int ti = i;
					int tj = j;
					subStr = "";
					while (l[ti][tj] != 0) {
						subStr = a.charAt(ti) + subStr;
						ti--;
						tj--;
					}
				}
			}
		}

		return subStr;
	}

	private static String solve(String a, String b) {
		String reverseB = reverse(b);

		// find longest common substring between a and reverseB
		String subStr = longestCommonSubstr(a, reverseB);
		String revSubStr = reverse(subStr);

		if (subStr.isEmpty()) {
			return "-1";
		}

		int i = a.indexOf(subStr);
		int j = b.indexOf(revSubStr);
		if (i + subStr.length() < a.length()) {
			subStr = subStr + a.charAt(i + subStr.length());
		} else if (j > 0) {
			revSubStr = b.charAt(j - 1) + revSubStr;
		}

		return subStr + revSubStr;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int queries = in.nextInt();
		for (int q = 0; q < queries; q++) {
			String a = in.next();
			String b = in.next();

			System.out.println(solve(a, b));

		}
	}
}
