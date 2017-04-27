package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThePowerSum {
	private static int solve(int x, int n, int num, double sum) {
		if (sum == x) {
			return 1;
		} else {
			int ans = 0;
			if (sum < x) {
				for (int i = num; i <= Math.pow(x, 1.0 / n); i++) {
					ans += solve(x, n, i + 1, sum + Math.pow(i, n));
				}
			}
			return ans;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int x = in.nextInt();
		int n = in.nextInt();

		System.out.println(solve(x, n, 1, 0));
	}
}
