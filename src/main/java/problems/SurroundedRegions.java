package problems;


/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example,
 * 
 * X X X X
 * 
 * X O O X
 * 
 * X X O X
 * 
 * X O X X
 * 
 * After running your function, the board should be:
 * 
 * X X X X
 * 
 * X X X X
 * 
 * X X X X
 * 
 * X O X X
 * 
 * 
 * @author lucas
 *
 */
public class SurroundedRegions {

	private static void print(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int c=0; c<array[i].length; c++) {				
				System.out.print(array[i][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static void solveInternal(char[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		grid[row][col] = '#';
		
		// go left
		if (col > 0 && grid[row][col - 1] == 'o') {
			solveInternal(grid, row, col-1);
		}

		// go up
		if (row > 0 && grid[row - 1][col] == 'o') {
			solveInternal(grid, row-1, col);
		}

		// go right
		if (col <cols-1 && grid[row][col+1] == 'o') {
			solveInternal(grid, row, col+1);
		}

		// got down
		if (row <rows-1 && grid[row+1][col] == 'o') {
			solveInternal(grid, row+1, col);
			if (grid[row+1][col] == '-') {
				grid[row][col] = '-';
			}
		}
		
		if (col==0 || row ==0 || col==cols-1 || row == rows-1) {
			grid[row][col] = '-';
		}
	}
	
	public static void solve(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int c=0; c<grid[i].length; c++) {			
				if (grid[i][c] == 'o') {
					solveInternal(grid, i, c);
				}
				
				if (grid[i][c] == '-') {
					grid[i][c] = 'o';
				}
				
				if (grid[i][c] == '#') {
					grid[i][c] = 'x';
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		char[][] grid = new char[][]{{'x', 'x', 'x', 'x'}, {'x', 'o', 'o', 'x'}, {'x', 'x', 'o', 'x'}, {'x', 'o', 'x', 'x'}, {'x', 'o', 'x', 'x'}};
		solve(grid);
		print(grid);
	}

}
