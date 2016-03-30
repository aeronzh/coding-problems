package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * James found a love letter his friend Harry has written for his girlfriend.
 * James is a prankster, so he decides to meddle with the letter. He changes all
 * the words in the letter into palindromes.
 * 
 * To do this, he follows two rules:
 * 
 * He can reduce the value of a letter, e.g. he can change d to c, but he cannot
 * change c to d. In order to form a palindrome, if he has to repeatedly reduce
 * the value of a letter, he can do it until the letter becomes a. Once a letter
 * has been changed to a, it can no longer be changed. Each reduction in the
 * value of any letter is counted as a single operation. Find the minimum number
 * of operations required to convert a given string into a palindrome.
 * 
 * Input Format
 * 
 * The first line contains an integer T, i.e., the number of test cases. The
 * next T lines will contain a string each. The strings do not contain any
 * spaces.
 * 
 * @author lucas
 *
 */
public class LoveLetterMystery {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			String s = scanner.next();
			char[] ch = s.toCharArray();
			int len = ch.length;
			int count = 0;
			for (int c = 0; c < len / 2; c++) {
				while (ch[c] > ch[len - c - 1]) {
					count++;
					ch[c] = (char) (ch[c] - 1);
				}

				while (ch[len - c - 1] > ch[c]) {
					count++;
					ch[len - c - 1] = (char) (ch[len - c - 1] - 1);
				}
			}

			System.out.println(count);
		}
	}

}
