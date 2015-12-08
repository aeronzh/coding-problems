package problems;

/**
 * A peak element is an element that is greater than its neighbors. Given an
 * input array where num[i] ≠ num[i+1], find a peak element and return its
 * index. The array may contain multiple peaks, in that case return the index to
 * any one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞. For example:
 * 
 * in array [1, 2, 3, 0, 4, 5, 2, 1, 4, 2], 3 is a peak element and your
 * function should return the index number 2. 10 9 8 7 6 5 4 3 2 1
 * 
 * 10 9 8 1 2 1 3
 * 
 * @author lucas
 *
 */
public class FindPeak {

	/**
	 * O(logn)
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static int findPeak(int[] array, int start, int end) {
		int mid = (start + end) / 2;

		if ((mid > 0 && mid < end) && (array[mid] > array[mid - 1] && array[mid] > array[mid + 1])) {
			return mid;
		} else if (mid == 0 && array[mid] > array[mid + 1]) {
			return mid;
		} else if (mid == end && array[mid] > array[mid - 1]) {
			return mid;
		}

		if (array[mid] < array[mid - 1]) {
			// a peak exists to the left
			return findPeak(array, start, mid - 1);
		}

		if (array[mid] < array[mid + 1]) {
			// e peak exists to the right
			return findPeak(array, mid + 1, end);
		}

		return 0;
	}

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 0, 4, 5, 2, 1, 4, 2 };
		System.out.println(findPeak(array, 0, array.length - 1));
	}

}
