package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of distinct elements. The task is to find triplets in array whose sum is zero.
 */
public class FindZeroSumTriplets {

	private static void pair(int i, int[] a) {
		int n = a.length;

		Set<Integer> set = new HashSet<Integer>();

		for (int j = i + 1; j < n; j++) {
			if (set.contains(-1 * (a[i] + a[j]))) {
				System.out.println(" (" + a[i] + ", " + (-1 * (a[i] + a[j])) + ", " + a[j] + ")");
				return;
			} else {
				set.add(a[j]);
			}
		}
	}

	private static void solve(int[] a) {
		int n = a.length;
		System.out.println("Solving for " + Arrays.toString(a));

		for (int i = 0; i < n; i++) {
			pair(i, a);
		}

		System.out.println();
	}

	public static void main(String[] args) {
		solve(new int[] { 0, -1, 2, -3, 1 });
		solve(new int[] { 1, -2, 1, 0, 5 });
		solve(new int[] { 0, 0, 0, 0 });
		solve(new int[] { -1, 2, -1, 3, -2 });
	}

}
