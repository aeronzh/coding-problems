package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Poker Nim is another 2-player game that's a simple variation on a Nim game.
 * The rules of the games are as follows:
 * 
 * The game starts with n piles of chips indexed from 0 to n-1. Each pile i has
 * ci chips. The players move in alternating turns. During each move, the
 * current player must perform either of the following actions:
 * 
 * Remove one or more chips from a single pile. Add one or more chips to a
 * single pile. At least chip must be added or removed during each turn.
 * 
 * To ensure that the game ends in finite time, a player cannot add chips to any
 * pile i more than k times. The player who removes the last chip wins the game.
 * Given the values of n,k , and the numbers of chips in each of the n piles,
 * determine whether the person who wins the game is the first or second person
 * to move. Assume both players move optimally.
 * 
 * Input Format
 * 
 * The first line contains an integer, T, denoting the number of test cases.
 * Each of the 2T subsequent lines defines a test case. Each test case is
 * described over the following two lines:
 * 
 * Two space-separated integers, n (the number of piles) and k (the maximum
 * number of times an individual player can add chips to some pile ),
 * respectively. n space-separated integers,c0, c1 ,...cn-1 where each describes
 * the number of chips at pile i .
 * 
 * @author lucas
 *
 */
public class PokerNim {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] p = new int[n];
			int x = 0;
			for (int i = 0; i < n; i++) {
				p[i] = in.nextInt();
				x ^= p[i];
			}

			System.out.println(x == 0 ? "Second" : "First");

		}

	}

}
