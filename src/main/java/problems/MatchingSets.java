package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Consider two n-element multisets (i.e., unordered and possibly containing
 * duplicate elements) of integers, X={x_0,x_1,...,x_(n-1) and
 * Y={y_0,y_1,...,y_(n-1) . You can perform the following operation on set :
 * 
 * 1. Choose two elements at some postions x_i and x_j where and 0<= i,j, <n and
 * i!=j.
 * 
 * 2. Decrement x_i by 1 and increment x_j by 1.
 * 
 * Given and X, Y find and print the minimum number of operations you must
 * perform so that X is equal to Y (i.e., both sets contain the same exact
 * values, and the order doesn't matter); if such a thing is not possible, print
 * -1 instead.
 * 
 * Input Format
 * 
 * The first line contains a single integer, n . The second line contains n
 * space-separated integers describing the respective values of set X. The third
 * line contains n space-separated integers describing the respective values of
 * set Y.
 * 
 * @author lucas
 *
 */
public class MatchingSets {

	private static void solve(int[] x, int[] y) {

		// Check
		Arrays.sort(x);
		Arrays.sort(y);

		BigInteger addSum = BigInteger.ZERO;
		BigInteger subSum = BigInteger.ZERO;

		for (int i = 0; i < x.length; i++) {
			int xNum = x[i];
			int yNum = y[i];

			if (xNum < yNum) {
				BigInteger a = new BigInteger("" + yNum);
				BigInteger b = new BigInteger("" + xNum);
				BigInteger d = a.subtract(b);
				addSum = addSum.add(d);
			}

			if (xNum > yNum) {
				BigInteger a = new BigInteger("" + xNum);
				BigInteger b = new BigInteger("" + yNum);
				BigInteger d = a.subtract(b);
				subSum = subSum.add(d);
			}
		}

		if (addSum.equals(subSum)) {
			System.out.println(subSum);
		} else {
			System.out.println("-1");
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
		}

		for (int i = 0; i < n; i++) {
			y[i] = in.nextInt();
		}

		solve(x, y);
	}
}
