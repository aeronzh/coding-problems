package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Shil has a string, S , consisting of N lowercase English letters. In one
 * operation, he can delete any pair of adjacent letters with same value. For
 * example, string "aabcc" would become either "aab" or "bcc" after 1 operation.
 * 
 * Shil wants to reduce as much as possible. To do this, he will repeat the
 * above operation as many times as it can be performed. Help Shil out by
 * finding and printing S's non-reducible form!
 * 
 * Note: If the final string is empty, print 'Empty String'.
 * 
 * Input Format
 * 
 * A single string, S.
 * 
 * Output Format
 * 
 * If the final string is empty, print 'Empty String'; otherwise, print the
 * final non-reducible string.
 * 
 * Sample Input 0
 * 
 * aaabccddd
 * 
 * Sample Output 0
 * 
 * abd
 * 
 * Sample Input 1
 * 
 * baab
 * 
 * Sample Output 1
 * 
 * Empty String
 * 
 * Sample Input 2
 * 
 * aa
 * 
 * Sample Output 2
 * 
 * Empty String
 * 
 * @author lucas
 *
 */
public class ReducedString {

	private static String reduce(String str) {
		int n = str.length();
		char[] s = str.toCharArray();

		StringBuilder sb = new StringBuilder();
		boolean reduced = false;
		for (int i = 0; i < n - 1; i++) {
			if (s[i] == s[i + 1] && !reduced) {
				// reduce
				reduced = true;
				i++;
				if (i == n - 1) {
					break;
				}
			} else if (s[i] == s[i + 1] && reduced) {
				sb.append(s[i + 1]);
				i++;
			} else if (s[i] != s[i + 1]) {
				sb.append(s[i]);
			}

			reduced = false;

		}

		if (sb.length() == 0) {
			return "";
		}

		char last = sb.charAt(sb.length() - 1);
		if (last != s[n - 1] && !reduced) {
			sb.append(s[n - 1]);
		}

		return sb.toString();
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		String str = in.next();
		String prev = str;
		String reduced = reduce(prev);
		while (!reduced.equals(prev)) {
			prev = reduced;
			reduced = reduce(prev);
		}

		if (reduced.isEmpty()) {
			System.out.println("Empty String");
		} else {
			System.out.println(reduced);
		}
	}
}
