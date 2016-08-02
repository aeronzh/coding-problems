package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Alice wrote a sequence of words in CamelCase as a string of letters, s,
 * having the following properties:
 * 
 * It is a concatenation of one or more words consisting of English letters. All
 * letters in the first word are lowercase. For each of the subsequent words,
 * the first letter is uppercase and rest of the letters are lowercase. Given ,
 * print the number of words in on a new line.
 * 
 * Input Format
 * 
 * A single line containing string s.
 * 
 * @author lucas
 *
 */
public class CamelCase {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		String s = in.next();

		// 65 - 90

		char[] c = s.toCharArray();
		int n = c.length;
		int count = 1;
		for (int i = 0; i < n; i++) {
			if (c[i] >= 65 && c[i] <= 90) {
				count++;
			}
		}

		System.out.println(count);
	}

}
