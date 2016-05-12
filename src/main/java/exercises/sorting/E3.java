package exercises.sorting;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, give an O(log n) algorithm that finds an element in the array. You may
 * assume that the array was originally sorted in increasing order.
 * 
 * EXAMPLE:
 * 
 * Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 * 
 * Output: 8 (the index of 5 in the array).
 * 
 * @author lucas
 *
 */
public class E3 {

	private static int findIndex(int num, int[] array, int start, int end) {
		int middle = (start + end) / 2;

		if (num == array[middle]) {
			// found
			return middle;
		} else if (num > array[middle] && num <= array[end]) {
			// go right
			return findIndex(num, array, middle + 1, end);
		} else if ((num < array[middle] && num >= array[start]) || (num > array[end])) {
			// go left
			return findIndex(num, array, start, middle - 1);
		} else {
			return -1;
		}
	}

	public static int findIndex(int num, int[] array) {
		return findIndex(num, array, 0, array.length - 1);
	}
}
