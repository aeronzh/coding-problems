package problems;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 3 4 5 6 7 might become 4 5 6 7 0 1 2 3).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1. You may assume no duplicate exists in the array.
 * 
 * @author lucas
 *
 */
public class SearchRotatedSortedArray {

	private static int find(int[] array, int n, int start, int end) {
		int middle = (start + end) / 2;
		int firstValue = array[start];
		int lastValue = array[end];

		if (array[middle] == n) {
			return middle;
		} else if (firstValue <= n && n < array[middle]) {
			// go left
			return find(array, n, start, middle - 1);
		} else if (firstValue <= n && n > array[middle] && n > lastValue) {
			// go left
			return find(array, n, start, middle - 1);
		} else if (array[middle] < n && n <= lastValue) {
			// go right
			return find(array, n, middle + 1, end);
		} else if (n < array[middle] && n <= lastValue) {
			// go right
			return find(array, n, middle + 1, end);
		}

		return -1;
	}

	private static int find(int[] array, int n) {
		return find(array, n, 0, array.length - 1);
	}

	public static void main(String[] args) {
		int[] array = { 4, 5, 6, 7, 0, 1, 2, 3 };
		int n = 1;

		System.out.println(find(array, n));
	}

}
