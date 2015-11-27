package com.lucaslouca.other;

/**
 * A robot is located at the top-left corner of a m x n grid. It can only move
 * either down or right at any point in time. The robot is trying to reach the
 * bottom-right corner of the grid.
 * 
 * How many possible unique paths are there?
 * 
 * @author lucas
 *
 */
public class UniquePaths {

	/**
	 * Given a NxN grid, let dp[i][j] = number of possible paths from grid[0][0]
	 * to grid[i][j]
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int solve(int n, int m) {
		int[][] dp = new int[n][m];

		// left column
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		// Top row
		for (int i = 0; i < m; i++) {
			dp[0][i] = 1;
		}

		for (int r = 1; r < n; r++) {
			for (int c = 1; c < m; c++) {
				dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
			}
		}

		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {
		System.out.println(solve(3, 3));
	}

}
