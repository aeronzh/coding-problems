package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Sunny and Johnny together have M dollars they want to spend on ice cream.
 * The parlor offers N flavors, and they want to choose two flavors so that
 * they end up spending the whole amount.
 * 
 * You are given the cost of these flavors. The cost of the ith flavor is
 * denoted by ci. You have to display the indices of the two flavors whose sum
 * is M.
 * 
 * @author lucas
 *
 */
public class IceCreamParlor {

	private static int[] solve(int[] a, int m) {
		Map<Integer, Integer> cost2index = new HashMap<Integer, Integer>();
		int n = a.length;
		for (int i = 0; i < n; i++) {
			if (cost2index.containsKey(m - a[i])) {
				return new int[] { cost2index.get(m - a[i]) + 1, i + 1 };
			}
			cost2index.put(a[i], i);
		}
		return new int[0];
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();

		for (int t = 1; t <= tests; t++) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			int[] result = solve(a, m);
			System.out.println(result[0] + " " + result[1]);
		}
	}

}
