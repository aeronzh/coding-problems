package problems;

/**
 * Print the number of ways to represent n cents by using the coins up to the
 * specified coinIndex of the coins array
 * 
 * @author lucas
 *
 */
public class CoinChange {

	static long[][] cache;

	private static long solve(int[] coins, int n, long current, int maxIndex) {
		if (current > n) {
			return 0;
		}

		if (cache[(int) current][maxIndex] != 0l) {
			return cache[(int) current][maxIndex];
		}

		if (current == n) {
			return 1;
		}

		long result = 0;
		for (int c = 0; c <= maxIndex; c++) {
			int coin = coins[c];
			result += solve(coins, n, current + coin, c);
			cache[(int) current][maxIndex] = result;
		}

		return result;

	}

	public static void main(String[] args) {
		int n = 250;
		int[] coins = { 41, 34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11 }; //15685693751
		int m = coins.length;

		cache = new long[n + 1][m];

		System.out.println(solve(coins, n, 0, coins.length - 1));

	}

}
