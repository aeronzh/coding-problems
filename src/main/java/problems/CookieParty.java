package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You're having a cookie party tonight! You're expecting n guests and you've
 * already made m cookies. You want to distribute all the cookies evenly between
 * your guests in such a way that each guest receives the same number of whole
 * cookies. If there are not enough cookies to give everyone the same amount,
 * you must make some number of additional cookies.
 * 
 * Given and n , m find and print the minimum number of additional cookies you must
 * make so that everybody receives the same number of cookies.
 * 
 * Input Format
 * 
 * A single line of two space-separated integers describing the respective
 * values of n and m.
 * 
 * @author lucas
 *
 */
public class CookieParty {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(); // Guests
		int m = in.nextInt(); // Cookies

		if (m == n) {
			System.out.println(0);
		} else if (m > n) {
			int mod = m % n;
			System.out.println(n - mod);
		} else {
			System.out.println(n - m);
		}

	}

}
