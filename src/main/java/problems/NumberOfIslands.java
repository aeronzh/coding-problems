package problems;

/**
 * Given a 2-d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110
 * 
 * 11010
 * 
 * 11000
 * 
 * 00000
 * 
 * Answer: 1
 * 
 * 
 * 
 * Example 2:
 * ja 
 * 11000
 * 
 * 11000
 * 
 * 00100
 * 
 * 00011
 * 
 * Answer: 3
 * 
 * @author lucas
 *
 */
public class NumberOfIslands {

	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int c=0; c<array[i].length; c++) {				
				System.out.print(array[i][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static int numberInternal(int[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;
		grid[row][col] = 2;
		
		// go left
		if (col > 0 && grid[row][col - 1] == 1) {
			numberInternal(grid, row, col-1);
		}

		// go up
		if (row > 0 && grid[row - 1][col] == 1) {
			numberInternal(grid, row-1, col);
		}

		// go right
		if (col <cols-1 && grid[row][col+1] == 1) {
			numberInternal(grid, row, col+1);
		}

		// got down
		if (row <rows-1 && grid[row+1][col] == 1) {
			numberInternal(grid, row+1, col);
		}
		
		// return
		return 1;
	}

	public static int number(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int c=0; c<grid[i].length; c++) {			
				if (grid[i][c] == 1) {
					count += numberInternal(grid, i, c);
				}
			}
		}
		
		
		return count;
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		System.out.println(number(grid));
		print(grid);
	}

}
