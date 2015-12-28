package problems;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array. Each element in the array represents your maximum
 * jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example, given array A = [2,3,1,1,4], the minimum number of jumps to
 * reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to
 * the last index.)
 * 
 * @author lucas
 *
 */
public class JumpGame2 {

	public static int solve(int[] a, int pos, int end, int count) {
		if (pos == end) {
			return count;
		} else {
			int max = a[pos];
			int minimumJumps = a.length;
			for (int i = 1; i <= max; i++) {
				int result = solve(a, pos + i, end, count + 1);
				if (result < minimumJumps) {
					minimumJumps = result;
				}
			}

			return minimumJumps;

		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1, 4 };
		int end = a.length - 1;
		System.out.println(solve(a, 0, end, 0));
	}

}
