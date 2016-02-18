package problems;

/**
 * Compute the minimal path sum in a nxn matrix, by starting in any cell in the
 * left column and finishing in any cell in the right column, and only moving
 * up, down, a nd right
 * 
 * 
 * 
 * @author lucas
 * 
 *
 */
public class PathSumThreeWays {

	private static int sum(int[][] matrix, int row, int col, int sum, boolean goingDown) {
		int columns = matrix[0].length;
		if (col == columns - 1) {
			return sum;
		} else {
			int rows = matrix.length;

			// we go down
			int down = Integer.MAX_VALUE;
			if (row + 1 < rows && goingDown) {
				down = sum(matrix, row + 1, col, sum + matrix[row + 1][col], true);
			}

			// we go right
			int right = Integer.MAX_VALUE;
			if (col + 1 < columns) {
				right = sum(matrix, row, col + 1, sum + matrix[row][col + 1], (row == 0));
			}

			// we go up
			int up = Integer.MAX_VALUE;
			if (row - 1 >= 0 && !goingDown) {
				up = sum(matrix, row - 1, col, sum + matrix[row - 1][col], false);
			}

			return Math.min(up, Math.min(down, right));
		}
	}

	private static int solve(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] dp = new int[rows][columns];

		for (int r = 0; r < rows; r++) {
			dp[r][0] = matrix[r][0];
		}

		for (int c = 1; c < columns; c++) {
			for (int r = 0; r < rows; r++) {
				if (r == 0) {
					int fromLeft = matrix[r][c] + dp[r][c - 1];
					dp[r][c] = fromLeft;
				} else if (r > 0 && r + 1 < rows) {
					int fromUp = matrix[r][c] + dp[r - 1][c];
					int fromLeft = matrix[r][c] + dp[r][c - 1];
					dp[r][c] = Math.min(fromUp, fromLeft);
				} else if (r == rows - 1) {
					int fromUp = matrix[r][c] + dp[r - 1][c];
					int fromLeft = matrix[r][c] + dp[r][c - 1];
					dp[r][c] = Math.min(fromUp, fromLeft);
				}
			}

			for (int r = rows - 2; r >= 0; r--) {
				int fromDown = matrix[r][c] + dp[r + 1][c];
				dp[r][c] = Math.min(dp[r][c], fromDown);
			}
		}

		int min = dp[0][columns - 1];
		for (int r = 1; r < rows; r++) {
			if (dp[r][columns - 1] < min) {
				min = dp[r][columns - 1];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		//		int[][] a = {
		//				{131, 673, 234, 103, 18},
		//				{201, 96, 342, 965, 150},
		//				{630, 803, 746, 422, 111},
		//				{537, 699, 497, 121, 956},
		//				{805, 732, 524, 37, 331}};

		int[][] a = { { 1, 1, 9, 1, 1 }, { 9, 1, 9, 1, 9 }, { 9, 1, 1, 1, 9 }, { 9, 9, 9, 9, 9 }, { 0, 0, 0, 0, 9 } };

		//		int[][] a = new int[1000][1000];

		//System.out.println(sum(a, 0, 0, 0, true));

		//		int[][] a = {{1}};
		System.out.println(solve(a));
	}

}
