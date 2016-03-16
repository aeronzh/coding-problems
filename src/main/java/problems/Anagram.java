package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Sid is obsessed with reading short stories. Being a CS student, he is doing
 * some interesting frequency analysis with the books. He chooses strings S1 and
 * S2 in such a way that |len(S1)−len(S2)|≤1.
 * 
 * Your task is to help him find the minimum number of characters of the first
 * string he needs to change to enable him to make it an anagram of the second
 * string.
 * 
 * Note: A word x is an anagram of another word y if we can produce y by
 * rearranging the letters of x.
 * 
 * Input Format
 * 
 * The first line will contain an integer, T, representing the number of test
 * cases. Each test case will contain a string having length len(S1)+len(S2),
 * which will be concatenation of both the strings described above in the
 * problem.The given string will contain only characters from a to z.
 * 
 * 
 * Output Format
 * 
 * An integer corresponding to each test case is printed in a different line,
 * i.e. the number of changes required for each test case. Print −1 if it is not
 * possible.
 * 
 * @author lucas
 *
 */
public class Anagram {

	private static int solve(String stra, String strb) {
		if (stra.length() != strb.length()) {
			return -1;
		} else {
			int[] a = new int[26];

			for (int i = 0; i < stra.length(); i++) {
				a[stra.charAt(i) - 97] = a[stra.charAt(i) - 97] + 1;
			}

			int[] b = new int[26];

			for (int i = 0; i < strb.length(); i++) {
				b[strb.charAt(i) - 97] = b[strb.charAt(i) - 97] + 1;
			}

			int[] diff = new int[26];
			int excess = 0;
			int negative = 0;
			for (int i = 0; i < 26; i++) {
				diff[i] = a[i] - b[i];
				if (diff[i] < 0) {
					negative += diff[i];
				}

				if (diff[i] > 0) {
					excess += diff[i];
				}
			}


			return Math.max(excess, negative);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);

		int tests = scanner.nextInt();
		for (int t = 1; t <= tests; t++) {
			String str = scanner.next();
			String stra = str.substring(0, str.length() / 2);
			String strb = str.substring(str.length() / 2);
			System.out.println(solve(stra, strb));
		}
	}
}
