package problems;

/**
 * Given an array A [1, 2, 3, 5, 6, 7 ] and number N.
 * 
 * This means that the array consists of the numbers from 0 ... N. However, as
 * you see, 4 is missing in A. Print the missing number.
 * 
 * 
 * @author lucas
 *
 */
public class MissingNumber {

	private static int solve(int[] a, int n) {
		int targetSum = (n * (n + 1)) / 2;
		int sum = 0;
		for (int i : a) {
			sum += i;
		}

		return (targetSum - sum);
	}

	public static void main(String[] args) {
		System.out.println(solve(new int[] { 1, 2, 3, 5, 6, 7 }, 7));

	}

}
