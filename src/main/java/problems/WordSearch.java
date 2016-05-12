package problems;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, given board =
 * 
 * [ ["ABCE"],
 * 
 * ["SFCS"],
 * 
 * ["ADEE"] ]
 * 
 * word = "ABCCED", -> returns true,
 * 
 * word = "SEE", -> returns true,
 * 
 * word = "ABCB", -> returns false.
 * 
 * @author lucas
 *
 */
public class WordSearch {
	private static void print(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int c = 0; c < array[i].length; c++) {
				System.out.print(array[i][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean solveInternal(char[][] grid, String target, String current, int targetIndex, int row, int col) {
		if (target.equals(current)) {
			return true;
		} else {
			int rows = grid.length;
			int cols = grid[0].length;
			char c = target.charAt(targetIndex + 1);

			
			boolean result = false;

			// go left
			if (col > 0 && grid[row][col - 1] == c) {
				grid[row][col] = '#';
				result = solveInternal(grid, target, current + c, targetIndex + 1, row, col - 1);
				grid[row][col] = c;
			}

			// go up
			if (result == false) {
				if (row > 0 && grid[row - 1][col] == c) {
					grid[row][col] = '#';
					result = solveInternal(grid, target, current + c, targetIndex + 1, row - 1, col);
					grid[row][col] = c;
				}
			}
			// go right
			if (result == false) {
				if (col < cols - 1 && grid[row][col + 1] == c) {
					grid[row][col] = '#';
					result = solveInternal(grid, target, current + c, targetIndex + 1, row, col + 1);
					grid[row][col] = c;
				}
			}
			// got down
			if (result == false) {
				if (row < rows - 1 && grid[row + 1][col] == c) {
					grid[row][col] = '#';
					result = solveInternal(grid, target, current + c, targetIndex + 1, row + 1, col);
					grid[row][col] = c;
				}
			}
			
			return result;

		}

	}

	private static boolean solve(char[][] grid, String target) {
		boolean result = false;
		OUTER_LOOP: for (int i = 0; i < grid.length; i++) {
			for (int c = 0; c < grid[i].length; c++) {
				char ch = target.charAt(0);
				if (grid[i][c] == ch) {
					result = solveInternal(grid, target, "" + target.charAt(0), 0, i, c);
					if (result == true) {
						break OUTER_LOOP;
					}
					
					if (grid[i][c] == '#') {
						grid[i][c] = ch;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		char[][] grid = new char[][] { { 'a', 'b', 'c', 'e' }, { 's', 'f', 'c', 's' }, { 'a', 'd', 'e', 'e' } };
//		print(grid);
//		System.out.println(ithpermutation(grid, "abcced")); // true
//		System.out.println(ithpermutation(grid, "see")); // true
		System.out.println(solve(grid, "abcb")); // false

	}
}
