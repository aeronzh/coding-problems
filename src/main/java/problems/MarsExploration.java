package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Sami's spaceship crashed on Mars! She sends sequential SOS messages to Earth
 * for help.
 * 
 * 
 * Letters in some of the SOS messages are altered by cosmic radiation during
 * transmission. Given the signal received by Earth as a string, , determine how
 * many letters of Sami's SOS have been changed by radiation.
 * 
 * 
 * Input Format
 * 
 * There is one line of input: a single string, S.
 * 
 * Note: As the original message is just SOS repeated n times, S's length will
 * be a multiple of 3.
 * 
 * Output Format
 * 
 * Print the number of letters in Sami's message that were altered by cosmic
 * radiation.
 * 
 * Sample Input 0
 * 
 * SOSSPSSQSSOR
 * 
 * Sample Output 0
 * 
 * 3
 * 
 * @author lucas
 *
 */
public class MarsExploration {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		String s = in.next();
		int n = s.length();
		char[] ch = s.toCharArray();
		int count = 0;
		for (int i = 0; i < n - 2; i = i + 3) {
			if (ch[i] != 'S') {
				count++;
			}
			if (ch[i + 1] != 'O') {
				count++;
			}
			if (ch[i + 2] != 'S') {
				count++;
			}
		}

		System.out.println(count);
	}
}
