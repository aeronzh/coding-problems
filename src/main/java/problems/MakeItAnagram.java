package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Alice recently started learning about cryptography and found that anagrams
 * are very useful. Two strings are anagrams of each other if they have same
 * character set (and frequency of characters) and same length. For example
 * strings "bacdc" and "dcbac" are anagrams, while strings "bacdc" and "dcbad"
 * are not.
 * 
 * Alice decides on an encryption scheme involving 2 large strings where
 * encryption is dependent on the minimum number of character deletions required
 * to make the two strings anagrams. She need your help in finding out this
 * number.
 * 
 * Given two strings (they can be of same or different length) help her in
 * finding out the minimum number of character deletions required to make two
 * strings anagrams. Any characters can be deleted from any of the strings.
 * 
 * @author lucas
 *
 */
public class MakeItAnagram {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);

		String strA = scanner.next();
		String strB = scanner.next();

		int[] a = new int[26];

		for (int i = 0; i < strA.length(); i++) {
			a[strA.charAt(i) - 97] = a[strA.charAt(i) - 97] + 1;
		}

		for (int i = 0; i < strB.length(); i++) {
			a[strB.charAt(i) - 97] = a[strB.charAt(i) - 97] - 1;
		}

		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += Math.abs(a[i]);
		}
		System.out.println(sum);
	}

}
