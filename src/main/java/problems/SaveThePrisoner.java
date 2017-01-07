package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A jail has prisoners, and each prisoner has a unique bikeNo number, S , ranging
 * from 1 to N. There are M sweets that must be distributed to the prisoners.
 * 
 * The jailer decides the fairest way to do this is by sitting the prisoners
 * down in a circle (ordered by ascending S), and then, starting with some
 * random S, distribute one candy at a time to each sequentially numbered
 * prisoner until all M candies are distributed. For example, if the jailer
 * picks prisoner S=2, then his distribution order would be
 * (2,3,4,5,...,n-1,n,1,2,3,4,...) until all sweets M are distributed.
 * 
 * But wait—there's a catch—the very last sweet is poisoned! Can you find and
 * print the ID number of the last prisoner to receive a sweet so he can be
 * warned?
 * 
 * Input Format
 * 
 * The first line contains an integer, T, denoting the number of test cases. The
 * subsequent lines each contain space-separated integers: N (the number of
 * prisoners), M (the number of sweets), and S (the prisoner ID), respectively.
 * 
 * @author lucas
 *
 */
public class SaveThePrisoner {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int s = in.nextInt();

			int result = 0;
			if (n - s >= m - 1) {
				result = s + m - 1;
			} else {
				result = (s + m) % n - 1;
				if (result == 0) {
					result = n;
				}
			}

			int expectedResult = outputScanner.nextInt();
			if (expectedResult != result) {
				System.out.println("Got " + result + " expected " + expectedResult + " for n=" + n + "  m=" + m + "  s=" + s);
			}
		}

	}

}
