package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Watson gives two integers (A and B) to Sherlock and asks if he can count the
 * number of square integers between A and B (both inclusive).
 * 
 * Note: A square integer is an integer which is the square of any integer. For
 * example, 1, 4, 9, and 16 are some of the square integers as they are squares
 * of 1, 2, 3, and 4, respectively.
 * 
 * Input Format
 * 
 * The first line contains T, the number of test cases. T test cases follow,
 * each in a new line. Each test case contains two space-separated integers
 * denoting A and B.
 * 
 * @author lucas
 *
 */
public class SherlockAndSquares {
	/********************************************************************************************************/

	private static void slow(int a, int b) {
		int ans = 0;

		for (int i = a; i <= b; i++) {
			double sq = Math.floor(Math.sqrt(i));
			if (sq * sq == i) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	/********************************************************************************************************/

	private static void slow2(int a, int b) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i <= Math.floor(Math.sqrt(1000000000)); i++) {
			set.add(i * i);
		}

		int ans = 0;
		for (int i = a; i <= b; i++) {
			if (set.contains(i)) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	/********************************************************************************************************/

	/**
	 * To find digital root of a number, add all its digits. If this sum is more
	 * than 9, add the digits of this sum. The single digit obtained at the end
	 * is the digital root of the number. For example, Digital Sum of 24566 is
	 * 2+4+5+6+6 = 23 = 2+3 = 5.
	 * 
	 * @param a
	 * @return
	 */
	private static int digitalRoot(int num) {
		int ans = 0;

		do {
			ans = 0;

			while (num > 0) {
				ans += (num % 10);
				num /= 10;
			}

			num = ans;
		} while (ans >= 10);

		return ans;
	}

	private static void slow3(int a, int b) {
		int ans = 0;
		for (int i = a; i <= b; i++) {
			// Step 1: A perfect square never ends in 2, 3, 7 or 8
			int mod = i % 10;
			if (mod != 2 && mod != 3 && mod != 7 && mod != 8) {
				int root = digitalRoot(i);
				// Step 2:  A perfect square will always have a digital root of 0, 1, 4 or 7.
				if (root == 0 || root == 1 || root == 4 || root == 7 || root == 9) {
					double sq = Math.floor(Math.sqrt(i));
					if (sq * sq == i) {
						ans++;
					}
				}
			}
		}

		System.out.println(ans);
	}

	/********************************************************************************************************/

	private static int solve(int a, int b) {
		// Count all integers found between the square roots given
		// See if the square root of starting number is say 5.6 and ending number is lets say 8.1 then in between you have 5.7 ,5.8, 5.9, 6, 6.1 and so on till 8.1. 
		// But we know that square root of only perfect square will be an integer, so the number of integers between 8.1 and 5.6 will tell us exactly how many perfect 
		// squares are there between corresponding numbers.
		
		int left = (int) (Math.ceil(Math.sqrt(a)));
		int right = (int) (Math.floor(Math.sqrt(b)));
		int ans = right - left + 1;
		if (a==b && Math.floor(Math.sqrt(a))*Math.floor(Math.sqrt(a)) == a) {
			ans = 1;
		}

		return ans;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		
		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int ans =solve(a, b);
			System.out.println(ans);
			
		}

	}
}
