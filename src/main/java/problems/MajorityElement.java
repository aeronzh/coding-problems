package problems;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than floor(n/2) times. (assume that the array
 * is non-empty and the majority element always exist in the array.)
 * 
 * @author lucas
 *
 */
public class MajorityElement {

	public static int solve(int[] array) {
		if (array.length == 1) {
			return array[0];
		}
		int n = array.length;
		System.out.println("n = " + n);

		int min = n / 2;
		System.out.println("floor(n/2) = " + min);

		Arrays.sort(array);

		// Since the majority always take more than a half space, the middle element is guaranteed to be the majority. 
		// Sorting array takes nlog(n). So the time complexity of this solution is nlog(n). 
		return array[min];
	}

	/**
	 * Boyer–Moore majority vote algorithm. Proof of correctness by Quara user:
	 * 
	 * Two scenarios exist that basically "cancel out" an occurrence of the
	 * majority element such that its contribution to the total running count
	 * variable is nullified. The scenarios:
	 * 
	 * 1) A non-majority element is encountered while the current "winner" is
	 * the majority element, causing the count to be decremented (thus
	 * nullifying one occurrence of the majority element).
	 * 
	 * 2) The majority element appears when a different element is the winner,
	 * causing that particular occurrence of the actual majority element to
	 * simply serve to decrement this phony "winner".
	 * 
	 * Any majority element occurrence that is not cancelled out causes the
	 * overall count to be incremented by 1. In order for either of the two
	 * cancellation scenarios outlined above to occur, there must be a
	 * corresponding non-matching element for the majority element being
	 * cancelled. However, by definition, a majority element will appear MORE
	 * times than all non-matching elements combined. So it is impossible to
	 * cancel out every occurrence, and the total count is guaranteed to be > 0.
	 * 
	 * @param a
	 * @param n
	 * @return
	 */
	public static int vote(int[] a) {
		int i, count = 0;
		int maj = a[0];
		int n = a.length;

		// Find candidate which occurs "most" of the time in the given array.
		for (i = 0; i < n; i++) {
			if (count == 0) {
				maj = a[i];
				count = 1;
			} else if (maj == a[i]) {
				count++;
			} else {
				count--;
			}
		}

		// Iterate over the array once again to determine if this candidate occurs maximum number of times
		count = 0;
		for (int number : a) {
			if (number == maj) {
				count++;
			}
		}

		if (count < (n + 1) / 2) {
			return -1;
		} else {
			return maj;
		}
	}

	public static void main(String[] args) {
		//int[] array = { 1, 8, 4, 4, 4, 3, 4, 4, 4, 4, 5, 6, 7 };
		int[] array = { 1, 4, 1, 4, 4, 2, 4, 4, 3, 3 };
		//	System.out.println("result = " + solve(array));
		System.out.println("result = " + vote(array));
	}

}
