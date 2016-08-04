package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Chief's bot is playing an old DOS-based game. There are N+1 buildings in the
 * game - indexed from 0 to N and are placed left-to-right. It is guaranteed
 * that building with index 0 will be of height 0 unit. For buildings with index
 * i (in in [1,N]) height will be h_i units.
 * 
 * At beginning Chief's bot is at building with index 0. At each step, bot jumps
 * to next (right) building. Suppose bot is at kth building and his current
 * energy is botEnergy, then in next step he will jump to (k+1)th building. He
 * will gain/lose energy equal in amount to difference between h_( k+1) and
 * botEnergy
 * 
 * If h_(k+1)> botEnergy, then he will lose h_(k+1) - botEnergy units of energy.
 * 
 * Otherwise, he will gain units of botEnergy - h_(k+1) energy.
 * 
 * Goal is to reach Nth building, and during the course bot should never have
 * negative energy units. What should be the minimum units of energy with which
 * bot should start to successfully complete the game?
 * 
 * Input Format
 * 
 * The first line contains integer N. Next line contains N space separated
 * integers h_1, h2, ... h_n representing the heights of the buildings.
 * 
 * Output Format
 * 
 * Print a single integer representing minimum units of energy required to
 * complete the game.
 * 
 * @author EX45141
 *
 */
public class ChiefHopper {

	private static int brute(int[] h) {
		int max = 100000;

		for (int e = 1; e <= max; e++) {
			BigInteger energy = new BigInteger("" + e);
			TEST: for (int i = 0; i < h.length - 1; i++) {
				if (energy.compareTo(new BigInteger("" + h[i + 1])) < 0) {
					BigInteger diff = new BigInteger("" + h[i + 1]).subtract(energy);
					energy = energy.subtract(diff);
				} else {
					BigInteger diff = energy.subtract(new BigInteger("" + h[i + 1]));
					energy = energy.add(diff);
				}

				if (energy.compareTo(BigInteger.ZERO) < 0) {
					break TEST;
				}
			}

			if (energy.compareTo(BigInteger.ZERO) >= 0) {
				return e;
			}
		}

		return max;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] h = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			h[i] = in.nextInt();
		}

		System.out.println(brute(h));
	}
}
