package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You are the benevolent ruler of Rankhacker Castle, and today you're
 * distributing bread to a straight line of N subjects. Each ith subject (where
 * 1<=1<=N ) already has Bi loaves of bread.
 * 
 * Times are hard and your castle's food stocks are dwindling, so you must
 * distribute as few loaves as possible according to the following rules:
 * 
 * 1. Every time you give a loaf of bread to some person , you must also give a
 * loaf of bread to the person immediately in front of or behind them in the
 * line (i.e., persons i+1 or i-1).
 * 
 * 2. After all the bread is distributed, each person must have an even number
 * of loaves.
 * 
 * Given the number of loaves already held by each citizen, find and print the
 * minimum number of loaves you must distribute to satisfy the two rules above.
 * If this is not possible, print NO.
 * 
 * 
 * @author lucas
 *
 */
public class FairRations {
	// 2 3 4 5 6
	private static void solve(int[] b) {
		int oddCount = 0;

		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 1) {
				oddCount++;
			}
		}

		if (oddCount % 2 != 0) {
			System.out.println("NO");
		} else {
			int lastOdd = -1;
			int gap = 0;
			for (int i = 0; i < b.length; i++) {
				if (b[i] % 2 == 1) {
					if (lastOdd != -1) {
						gap += (i - lastOdd);
						lastOdd = -1;
					} else {
						lastOdd = i;
					}
				}
			}

			System.out.println(gap * 2);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = in.nextInt();
		}

		solve(b);

	}
}
