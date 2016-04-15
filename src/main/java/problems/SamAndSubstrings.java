package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * Samantha and Sam are playing a game. They have 'N' balls in front of them,
 * each ball numbered from 0 to 9, except the first ball which is numbered from
 * 1 to 9. Samantha calculates all the sub-strings of the number thus formed,
 * one by one. If the sub-string is S, Sam has to throw 'S' candies into an
 * initially empty box. At the end of the game, Sam has to find out the total
 * number of candies in the box, T. As T can be large, Samantha asks Sam to tell
 * T % (10^9+7) instead. If Sam answers correctly, he can keep all the candies.
 * Sam can't take all this Maths and asks for your help.
 * 
 * Help him!
 * 
 * Input Format A single line containing a string of numbers that appear on the
 * first, second, third ball and so on.
 * 
 * Output Format A single line which is the number of candies in the box, T %
 * (10^9+7)
 * 
 * 
 * Sample Input #01
 * 
 * 123
 * 
 * 
 * Sample Output #01
 * 
 * 164
 * 
 * Explanation #01
 * 
 * The sub-strings of 123 are 1, 2, 3, 12, 23, 123 which sums to 164.
 * 
 * 
 * 
 * Created by lucas on 12/04/16.
 */

// 123 23 3 
public class SamAndSubstrings {
	private static final long MODULO = 1000000007;

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}

	private static long brute(String str) {
		long sum = 0;

		char[] ch = str.toCharArray();
		for (int i = 0; i <= ch.length; i++) {
			for (int j = i; j <= ch.length; j++) {
				String tmp = str.substring(i, j);
				if (!tmp.isEmpty()) {
					long num = Long.parseLong(tmp);
					sum = (sum + num) % MODULO;
				}
			}
		}

		return sum;
	}

	//
	// Example:
	// 123
	// 
	// Substrings:
	// 1 2 3 12 23 123
	// 
	// Digit   Unit                          Ten                   Hundred
	// '1'      1                             1                      1  
	// '2'      2 ('2','12')                  2 ('23', '123')
	// '3'      3 ('3', '23', '123')
	// 
	//  '1': 1*1*111
	//  '2': 2*2*11
	//  '3': 3*3*1
	//
	private static BigInteger solve(int[] a) {
		BigInteger sum = BigInteger.ZERO;

		BigInteger x = BigInteger.ONE;
		for (int i = a.length - 1; i >= 0; i--) {
			BigInteger digit = new BigInteger("" + a[i]);
			BigInteger index = new BigInteger("" + (i + 1));
			sum = sum.add(digit.multiply(index).multiply(x)).mod(new BigInteger("" + MODULO));
			x = x.multiply(new BigInteger("10")).add(BigInteger.ONE).mod(new BigInteger("" + MODULO));
		}

		return sum;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		String line = scanner.next();
		char[] splitted = line.toCharArray();
		int[] a = new int[splitted.length];
		for (int i = 0; i < splitted.length; i++) {
			a[i] = splitted[i] - '0';
		}

		System.out.println(solve(a));
	}
}
