package problems;

/**
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * 
 * @author lucas
 *
 */
public class HouseRobber2 {

	public static int rob(int[] num) {

		int[] dp = new int[num.length+1];
		
		// Include first, but not last element
		dp[0] = 0;
		dp[1] = num[0];
		
		for (int i=2; i<num.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+num[i-1]);
		}
		
		int[] dr = new int[num.length+1];
		
		// Include last, but not first element
		dr[0] = 0;
		dr[1] = num[1];
		
		for (int i=2; i<num.length; i++) {
			dr[i] = Math.max(dr[i-1], dr[i-2]+num[i]);
		}
		
		return Math.max(dp[num.length-1],dr[num.length-1]);
	}
	
	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1, 9, 0, 2, 44, 45, 50, 32 }));
	}

}
