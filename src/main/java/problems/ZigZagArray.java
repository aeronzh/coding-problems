package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZigZagArray {
	private static int solve(int n, int[] a) {
		int ans = 0;
		// 5 2 3 6 1
		for (int i = 0; i < n; i++) {
			if (i + 2 < n) {
				if ((a[i]<a[i+1] && a[i+1]<a[i+2]) || (a[i]>a[i+1] && a[i+1]>a[i+2])) {
					ans++;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		System.out.println(solve(n, a));
	}

}
