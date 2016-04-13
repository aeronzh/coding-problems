package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public static long pow(long x, long n, long p) {
		long result = 1;
		while (n > 0) {
			if ((n & 1) == 1) {
				result = (result * x) % p;
			}

			x = (x * x) % p;
			n = n >> 1;
		}

		return result;
	}

	public static long c(int n, int k, long p) {
		// C(n,k) = n!/(k!*(n-k)!)

		long numerator = 1;
		for (int i = 0; i < k; i++) {
			numerator = (numerator * (n - i)) % p;
		}

		long denominator = 1;
		for (int i = 1; i <= k; i++) {
			denominator = (denominator * i) % p;
		}

		return (numerator * (pow(denominator, p - 2, p))) % p;
	}
	
	private static long substrings(String str) {
		long sum = 0;
		
		char[] ch = str.toCharArray();
		for (int i=0; i<=ch.length; i++) {
			for (int j=i; j<=ch.length; j++) {
				String tmp = str.substring(i,j);
				if (!tmp.isEmpty()) {
					long num = Long.parseLong(tmp);
					sum = (sum + num) % MODULO;
				}
			}
		}
		
		return sum;
	}

	/*
	 * 123
	 * 
	 * 1 2 3 12 23 123 = 164
	 * 1 3 6 18 41 164
	 * 
	 * 
	 * Example :
	 * 
	 * current char is '3' and previous sum is 3. Then the current sum is 3+3=6.
	 * 
	 * current char is '2' (from substr 12) and the previous sum is 6 and len of substr is 2.
	 * 
	 * 
	 * dp[][] with dp[i][j] = sum if ith character is equal to j. Example dp[2][2] = 
	 */
	
	private static void solve(int[] a) {
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		String line = scanner.next();
		char[] splitted = line.toCharArray();
		int[] a = new int[splitted.length];
		for (int i = 0; i < splitted.length; i++) {
			a[i] = splitted[i] - 48;
		}
		
		System.out.println(substrings("123"));
	}
}
