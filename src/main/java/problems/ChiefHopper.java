package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class ChiefHopper {

	private static int brute(int[] h) {
		int max = 100000;

		for (int e = 1; e <= max; e++) {
			BigInteger energy = new BigInteger(""+e);
			TEST: for (int i = 0; i < h.length-1; i++) {
				if (energy.compareTo(new BigInteger(""+h[i+1])) < 0) {
					BigInteger diff = new BigInteger(""+h[i+1]).subtract(energy);
					energy = energy.subtract(diff);
				} else {
					BigInteger diff = energy.subtract(new BigInteger(""+h[i+1]));
					energy = energy.add(diff);
				}

				if (energy.compareTo(BigInteger.ZERO) <= 0) {
					break TEST;
				}
			}

			if (energy.compareTo(BigInteger.ZERO) >= 0) {
				return e;
			}
		}

		return max;
	}

	private static void solve(int[] h) {
		// 3 4 3 2 4
		// 3 
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] h = new int[n+1];
		for (int i = 1; i <= n; i++) {
			h[i] = in.nextInt();
		}

		System.out.println(brute(h));
	}
}
