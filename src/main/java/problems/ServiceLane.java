package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ServiceLane {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		//		Scanner out = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		int n = in.nextInt();
		int tests = in.nextInt();
		int[] lane = new int[n];
		for (int i = 0; i < n; i++) {
			lane[i] = in.nextInt();
		}

		// 2 3 1 2 3 2 3 3

		for (int t = 0; t < tests; t++) {
			int i = in.nextInt();
			int j = in.nextInt();
			int min = lane[i];
			for (int k = i; k <= j; k++) {
				min = Math.min(min, lane[k]);
			}

			System.out.println(min);
		}

	}
}
