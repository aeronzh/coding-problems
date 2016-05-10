package problems;

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
public class Robot2 {

	/**
	 * Given a NxN grid, let ways[i][j] = number of possible paths from
	 * grid[0][0] to grid[i][j]
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int count(int m, int n) {
		int[][] ways = new int[m][n];

		// left column
		for (int i = 0; i < m; i++) {
			ways[i][0] = 1;
		}

		// top row
		for (int i = 0; i < n; i++) {
			ways[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				ways[i][j] = ways[i][j - 1] + ways[i - 1][j];
			}
		}
		
		return ways[m-1][n-1];
	}

	public static void main(String[] args) {
		System.out.println(count(3,3));
	}

}
