package exercises.recursion;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5
 * cents) and pennies (1 cent), write code to calculate the number of ways of
 * representing n cents.
 * 
 * @author lucas
 *
 */
public class E7 {
	public static int numOfWays(int n, int curSum, int[] coins, int curIndex) {
		if (curSum == n) {
			return 1;
		}

		int result = 0;
		for (int i = curIndex; i < coins.length; i++) {
			if (curSum + coins[i] <= n) {
				result += numOfWays(n, curSum + coins[i], coins, i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 5, 10, 25 };
		int count = numOfWays(10, 0, coins, 0);
		System.out.println(count);
	}

}
