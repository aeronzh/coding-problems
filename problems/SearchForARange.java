package com.lucaslouca.other;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value. Your algorithm's runtime complexity must be in the order
 * of O(log n). If the target is not found in the array, return [-1, -1]. For
 * example, given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author lucas
 *
 */
public class SearchForARange {

	public static int[] find(int[] array, int n, int start, int end, int[] found) {
		if (start <= end) {
			int middle = (end - start) / 2;

			if (array[start + middle - 1] == n) {
				if ((start + middle - 1) < found[0]) {
					// found smaller left
					found[0] = start + middle - 1;
				}

				if ((start + middle - 1) > found[1]) {
					// found bigger right
					found[1] = start + middle - 1;
				}

				// go left
				find(array, n, start, (start + middle - 1), found);

				// go right
				find(array, n, (start + middle + 1), end, found);

			} else if (array[start + middle] > n) {
				// go left
				find(array, n, start, (start + middle - 1), found);
			} else {
				// go right
				find(array, n, (start + middle + 1), end, found);
			}
		}

		if (found[0] == array.length) {
			found = new int[] { -1, -1 };
		}

		return found;
	}

	public static int[] find(int[] array, int n) {
		return find(array, n, 0, array.length - 1, new int[] { array.length, -1 });
	}

	public static void main(String[] args) {
		int[] array = { 5, 7, 7, 8, 8, 10 };
		int n = 8;

		int[] result = find(array, n);
		System.out.println(result[0] + ", " + result[1]);
	}

}
