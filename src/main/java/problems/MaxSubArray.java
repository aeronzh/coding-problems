package problems;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * @author lucas
 *
 */
public class MaxSubArray {

	public static void solve(int[] array) {
		int newSum = array[0];
		int max = array[0];

		int start = 0;
		int end = 0;

		for (int i = 1; i < array.length; i++) {
			// Keep previous sum or start fresh with just array[i]
			if (array[i] > newSum + array[i]) {
				newSum = array[i];
				start = i;
			} else {
				newSum = newSum + array[i];
			}

			// Check if we have a new max
			if (newSum > max) {
				max = newSum;
				end = i;
			}
		}

		System.out.println("max=" + max + " start=" + start + "  end=" + end);
	}

	public static void main(String[] args) {
		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		solve(array);

	}

}
