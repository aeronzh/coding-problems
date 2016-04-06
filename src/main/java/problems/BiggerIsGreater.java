package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a word w, rearrange the letters of w to construct another word s in
 * such a way that s is lexicographically greater than w. In case of multiple
 * possible answers, find the lexicographically smallest one among them.
 * 
 * Input Format
 * 
 * The first line of input contains t, the number of test cases. Each of the
 * next t lines contains w.
 * 
 * Constraints
 * 
 * 1≤t≤10^5
 * 
 * 1≤|w|≤100 w will contain only lower-case
 * 
 * English letters and its length will not exceed 100.
 * 
 * Output Format
 * 
 * For each testcase, output a string lexicographically bigger than w in a
 * separate line. In case of multiple possible answers, print the
 * lexicographically smallest one, and if no answer exists, print no answer.
 * 
 * Sample Input
 * 
 * 5
 * 
 * ab
 * 
 * bb
 * 
 * hefg
 * 
 * dhck
 * 
 * dkhc
 * 
 * 
 * Sample Output
 * 
 * ba
 * 
 * no answer
 * 
 * hegf
 * 
 * dhkc
 * 
 * hcdk
 * 
 * Explanation
 * 
 * Test case 1: There exists only one string greater than ab which can be built
 * by rearranging ab. That is ba.
 * 
 * Test case 2: Not possible to rearrange bb and get a lexicographically greater
 * string.
 * 
 * Test case 3: hegf is the next string lexicographically greater than hefg.
 * 
 * Test case 4: dhkc is the next string lexicographically greater than dhck.
 * 
 * Test case 5: hcdk is the next string lexicographically greater than dkhc.
 * 
 * @author lucas
 *
 */
public class BiggerIsGreater {

	private static String solve(String word) {
		char[] ch = word.toCharArray();
		int n = word.length() - 1;

		// Start from nth character and find the next smallest
		int j = n;
		while (j > 0) {
			int i = j;
			while (i > 0 && ch[i - 1] >= ch[i]) {
				i--;
			}

			if (i > 0 && ch[i - 1] < ch[j]) {
				// swap smaller char with larger
				// That is we brought a large char up to the front.
				// Next we need to sort the rest
				char tmp = ch[i - 1];
				ch[i - 1] = ch[j];
				ch[j] = tmp;

				// Get head
				char[] head = new char[i];
				for (int t = 0; t <= i - 1; t++) {
					head[t] = ch[t];
				}

				// Get tail
				char[] tail = new char[n - (i - 1)];
				for (int t = i; t <= n; t++) {
					tail[t - i] = ch[t];
				}

				// Sort tail
				Arrays.sort(tail);

				return (new String(head)) + (new String(tail));
			} else {
				j--;
			}
		}

		return new String(ch);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String word = scanner.next();
			String result = solve(word);
			if (result.equals(word)) {
				System.out.println("no answer");
			} else {
				System.out.println(solve(word));
			}
		}

	}
}
