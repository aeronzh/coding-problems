package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/an-interesting-game-1
public class AnInterestingGame {
	private static final String BOB = "BOB";
	private static final String ANDY = "ANDY";

	private static void solve(int n, int[] a, int start, int end, String player) {
		if (start > end) {
			System.out.println(player.equals(BOB) ? ANDY : BOB);
		} else {
			int max = Integer.MIN_VALUE;
			int maxIdx = -1;
			for (int i = start; i <= end; i++) {
				if (a[i] > max) {
					max = a[i];
					maxIdx = i;
				}
			}

			solve(n, a, start, maxIdx - 1, player.equals(BOB) ? ANDY : BOB);
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		int games = in.nextInt();
		for (int g = 0; g < games; g++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}

			solve(n, a, 0, a.length - 1, BOB);
		}
	}

}
