package problems;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length of 2 under the problem constraint.
 * 
 * 
 * 1 2 2 3 3 4
 * 
 * 
 * @author lucas
 *
 */
public class MinSubarraySum {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
	}

	private static int sum(int[] array, int start, int end) {
		int result = 0;
		for (int i = start; i <= end; i++) {
			result += array[i];
		}
		return result;
	}

	private static int minimalSubarray(int[] array, int s) {
		int sum;
		for (int len = 0; len < array.length; len++) {
			for (int index = 0; index < array.length - len; index++) {
				sum = sum(array, index, index + len);

				if (sum >= s) {
					System.out.println("index: " + index + " - " + (index + len) + " sum=" + sum);
					return len + 1;
				}
			}
		}

		return 0;
	}

	public static int minSubArrayLen(int s, int[] array) {
		int start = 0;
		int end = 0;
		int minLen = array.length;
		int size = array.length;
		int sum = 0;
		while (end < size) {

			// Add elements as long as the sum is smaller than s
			while (sum <= s && end < size) {
				sum += array[end++];
			}

			// Remove elements until sum is smaller or equal than s
			while (sum >= s) {

				// Check if we have a new minimum subarray length
				if (end - start < minLen) {
					minLen = end - start;
				}

				sum -= array[start++];
			}
		}

		return minLen;
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 1, 2, 7, 3 };
		System.out.println(minimalSubarray(array, 7));
		System.out.println(minSubArrayLen(7, array));
	}

}
