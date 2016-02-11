package problems;

/**
 * Given an array of integers, count number of subarrays (of size more than one)
 * that are strictly increasing.
 * 
 * @author lucas
 *
 */
public class IncreasingSubarrays {

	public static int solve(int[] a) {
		int min = 0;
		int count = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] < a[i]) {
				count++;
				count += i - 1 - min;
			} else {
				min = i;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 2 };
		System.out.println(solve(a));
	}

}
