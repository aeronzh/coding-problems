package problems;

/**
 * 4*N wall 4x1 or 1x4 bricks
 * 
 * @author lucas
 * 
 *           20     34  3    31     35      10     38     18   27    15   3        38       14 18 4 5 23 9 31 10 25
 * 
 *                3385  0    1432   4522    6      10794  42   462   19   0        10794    15 42 1 2 155 4 1432 6 269
 *
 */
public class RedJohn {

	public static long c(int n, int k) {
		// C(n,k) = n!/(k!*(n-k)!)

		long numerator = 1;
		for (int i = 0; i < k; i++) {
			numerator = (numerator * (n - i));
		}

//        System.out.println(numerator);

        long denominator = 1;
		for (int i = 1; i <= k; i++) {
			denominator = (denominator * i);
		}

		return numerator / denominator;
	}

	private static int countPrimes(int n) {
		boolean[] dp = new boolean[n + 1];

		dp[0] = false;
		dp[1] = false;
		for (int p = 2; p <= n; p++) {
			dp[p] = true;
		}

		for (int p = 2; p <= n; p++) {
			if (dp[p]) {
				for (int c = p; c <= n / p; c++) {
					dp[c * p] = false;
				}
			}
		}

		// count
		int count = 0;
		for (int p = 2; p <= n; p++) {
			if (dp[p]) {
				count++;
			}
		}

		return count;
	}

    private static int solve(int n) {
        if (n<4) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;

        for (int i=5; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-4];
        }

        return dp[n];
    }


	private static int solveCombinatorics(int n) {
		int total = 0;
		int maxBlocks = n / 4;

		for (int b=0; b<=maxBlocks; b++) {
			int rest = n - b * 4;
            total += c(rest + b, rest);
		}
		
		return total;
	}

	// - * * * * - - * * * *  * * * * - * * * *  * * * * - * * * * - * * * *
	
	// - - - * * * *
	public static void main(String[] args) {
		System.out.println(countPrimes(solve(38)));
        //System.out.println(solve(1));

	}

}
