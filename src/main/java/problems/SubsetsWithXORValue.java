package problems;

/**
 * Given an array arr[] of n numbers and a number K, find the number of subsets
 * of arr[] having XOR of elements as K
 * 
 * Input: arr[] = {6, 9, 4, 2}, k = 6 Output: 2 The subsets are {4, 2} and {6}
 * 
 * Input: arr[] = {1, 2, 3, 4, 5}, k = 4 Output: 4 The subsets are {1, 5}, {4},
 * {1, 2, 3, 4} and {2, 3, 5}
 * 
 * @author lucas
 *
 */
public class SubsetsWithXORValue {

	public static int solve(int[] a, int k) {
		int len = a.length;

		//int max = Math.pow(2,(log2(Math.max(a))+1))­ 1;

		// dp[i][j] = number of subsets in [0..i-1] with XOR value j
		int[][] dp = new int[len + 1][k + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= len; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j ^ a[i - 1]];
			}
		}

		return dp[len][k];
	}

	public static void main(String[] args) {
		System.out.println(solve(new int[] { 6, 9, 4, 2 }, 6));

	}

}
