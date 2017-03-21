package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class RecursiveDigitSum {
	private static BigInteger sum(BigInteger p) {
		BigInteger ans = BigInteger.ZERO;

		String num = p.toString();
		for (int i = 0; i < num.length(); i++) {
			ans = ans.add(new BigInteger("" + num.charAt(i)));
		}

		return ans;
	}

	private static BigInteger solve(BigInteger p, int k) {
		BigInteger sum = sum(p);
		BigInteger ksum = sum.multiply(new BigInteger("" + k));
		BigInteger spr = sum(ksum);
		if (spr.toString().length() > 1) {
			return solve(sum(p), k);
		}
		return spr;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		String n = in.next();
		int k = in.nextInt();

		BigInteger p = new BigInteger(n);
		System.out.println(solve(p, k));
	}
}
