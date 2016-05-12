package problems;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * @author lucas
 *
 */

// 1, 1, 1, 12
// 5, 2, 1, 19
// 4, 3, 1, 100
// 2, 55, 1, 1
public class MinimumPathSum {
	public static int[][] grid = { { 1, 1, 1, 12 }, { 5, 2, 1, 19 }, { 4, 3, 1, 100 }, { 2, 55, 1, 1 } };

	//
	private static int find(int row, int col, int cur) {
		if ((row < grid.length - 1) && (col < grid[0].length - 1)) {
			int down = find(row + 1, col, cur + grid[row + 1][col]);
			int right = find(row, col + 1, cur + grid[row][col + 1]);
			return Math.min(down, right);
		} else if (row < grid.length - 1) {
			return find(row + 1, col, cur + grid[row + 1][col]);
		} else if (col < grid[0].length - 1) {
			return find(row, col + 1, cur + grid[row][col + 1]);
		} else {
			return cur;
		}
	}
	
	
	// dynamic programming
	public static int minPathSum(int[][] grid) {
	    if(grid == null || grid.length==0)
	        return 0;
	 
	    int m = grid.length;
	    int n = grid[0].length;
	 
	    int[][] dp = new int[m][n];
	    dp[0][0] = grid[0][0];    
	 
	    // initialize top row
	    for(int i=1; i<n; i++){
	        dp[0][i] = dp[0][i-1] + grid[0][i];
	    }
	 
	    // initialize left column
	    for(int j=1; j<m; j++){
	        dp[j][0] = dp[j-1][0] + grid[j][0];
	    }
	    
	    // fill up the dp table
	    for(int i=1; i<m; i++){
	        for(int j=1; j<n; j++){
	            if(dp[i-1][j] > dp[i][j-1]){
	                dp[i][j] = dp[i][j-1] + grid[i][j];
	            }else{
	                dp[i][j] = dp[i-1][j] + grid[i][j];
	            }
	        }
	    }
	 
	    return dp[m-1][n-1];
	}

	public static void main(String[] args) {
		System.out.println(find(0, 0, grid[0][0]));

	}

}
