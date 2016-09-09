package problems;

/**
 * Suppose you have a sorted array of infinite numbers, how would you search an
 * element in the array?
 * 
 * Source: Amazon Interview Experience.
 * 
 * Since array is sorted, the first thing clicks into mind is binary search, but
 * the problem here is that we don’t know size of array. If the array is
 * infinite, that means we don’t have proper bounds to apply binary search. So
 * in order to find position of key, first we find bounds and then apply binary
 * search algorithm.
 * 
 * Let low be pointing to 1st element and high pointing to 2nd element of array,
 * Now compare key with high index element, ->if it is greater than high index
 * element then copy high index in low index and double the high index. ->if it
 * is smaller, then apply binary search on high and low indices found. Below are
 * implementations of above algorithm
 * 
 * @author lucas
 *
 */
public class FindPositionOfElementInSortedInfiniteArray {

	private static int binarySearch(int[] a, int l, int h, int x) {
		if (l <= h) {
			int mid = (l + h) / 2;

			if (x == a[mid]) {
				return mid;
			} else if (x > a[mid]) {
				return binarySearch(a, mid + 1, h, x);
			} else {
				return binarySearch(a, l, mid - 1, x);
			}

		} else {
			return -1;
		}
	}

	private static void solve(int[] a, int x) {
		// find bounds first
		int l = 0;
		int h = 1;
		int val = a[h];
		while (x > val) {
			l = h;
			h = 2 * h;
			val = a[h];
		}

		System.out.println(binarySearch(a, l, h, x));
	}

	public static void main(String[] args) {
		int a[] = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int x = 10;
		solve(a, x); // 4
	}
}
