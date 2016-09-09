package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find the first repeating element in it. We need
 * to find the element that occurs more than once and whose index of first
 * occurrence is smallest.
 * 
 * @author lucas
 *
 */
public class FindFirstRepeatingElementInArray {

	private static void solve(int[] a) {
		Set<Integer> set = new HashSet<Integer>();

		int index = Integer.MAX_VALUE;
		for (int i = a.length - 1; i >= 0; i--) {
			if (set.contains(a[i])) {
				if (i < index) {
					index = i;
				}
			}

			set.add(a[i]);
		}

		System.out.println(a[index]);
	}

	public static void main(String[] args) {
		int a[] = { 10, 5, 3, 4, 3, 5, 6 };
		solve(a);
	}

}
