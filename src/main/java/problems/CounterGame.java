package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Louise and Richard play a game. They have a counter set to N. Louise gets the
 * first turn and the turns alternate thereafter. In the game, they perform the
 * following operations.
 * 
 * If N is not a power of 2, reduce the counter by the largest power of 2 less
 * than N. If N is a power of 2, reduce the counter by half of N. The resultant
 * value is the new N which is again used for subsequent operations. The game
 * ends when the counter reduces to 1, i.e., N == 1, and the last person to make
 * a valid move wins.
 * 
 * Given N, your task is to find the winner of the game.
 * 
 * Update If they set counter to 1, Richard wins, because its Louise' turn and
 * she cannot make a move.
 * 
 * Input Format The first line contains an integer T, the number of testcases. T
 * lines follow. Each line contains N, the initial number set in the counter.
 * 
 * @author lucas
 *
 */
public class CounterGame {

	static BigInteger getNumber(BigInteger n) {
		int bitLen = n.bitLength();
		BigInteger number = BigInteger.ONE;
		if (n.equals(BigInteger.ONE)) {
			return BigInteger.ZERO;
		} else {
			if (n.testBit(bitLen - 1) && n.bitCount() == 1) {
				// If N is a power of 2, reduce the counter by half of N.
				number = n.subtract(n.divide(new BigInteger("2")));
			} else if (n.bitCount() > 1) {
				// If N is not a power of 2, reduce the counter by the largest power of 2 less than N.
				number = n.subtract(number.shiftLeft(bitLen - 1));
			}

			return number;
		}
	}

	static String solve(BigInteger n) {
		final String LOUISE = "Louise";
		final String RICHARD = "Richard";

		String player = LOUISE;
		while (n.compareTo(BigInteger.ONE) > 0) {
			//			System.out.print(player + " reduces " + n);
			n = getNumber(n);
			if (!n.equals(BigInteger.ONE)) {
				player = (LOUISE.equals(player)) ? RICHARD : LOUISE;
			}
			//			System.out.println("  to " + n);
		}

		return player;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		int tests = scanner.nextInt();
		for (int t = 1; t <= tests; t++) {
			String str = scanner.next();
			String result = solve(new BigInteger(str));

			String expectedResult = outputScanner.next();
			if (!result.equals(expectedResult)) {
				System.out.println("*** got= " + result + "    expected= " + expectedResult + "  for " + str);
			} else {
				System.out.println(result);
			}
		}

	}

}
