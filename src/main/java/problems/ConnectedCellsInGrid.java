package problems;

/**
 * You are given a matrix with m rows and nn columns of cells, each of which
 * contains either 1 or 0. Two cells are said to be connected if they are
 * adjacent to each other horizontally, vertically, or diagonally. The connected
 * and filled (i.e. cells that contain a 1) cells form a region. There may be
 * several regions in the matrix. Find the number of cells in the largest region
 * in the matrix.
 * 
 * Input Format There will be three parts of t input: The first line will
 * contain m, the number of rows in the matrix. The second line will contain n,
 * the number of columns in the matrix. This will be followed by the matrix
 * grid: the list of numbers that make up the matrix.
 * 
 * Output Format Print the length of the largest region in the given matrix.
 * 
 * @author lucas
 *
 */
public class ConnectedCellsInGrid {

	private static int solve(int[][] a, int row, int col, boolean[][] marked) {
		int rows = a.length;
		int columns = a[0].length;

		marked[row][col] = true;
		int result = 1;

		for (int coff = -1; coff <= 1; coff++) {
			for (int roff = -1; roff <= 1; roff++) {
				int targetRow = row + roff;
				int targetCol = col + coff;
				if (targetRow < rows && targetCol < columns && targetRow >= 0 && targetCol >= 0) {
					if (a[targetRow][targetCol] == 1 && marked[targetRow][targetCol] == false) {
						result += solve(a, targetRow, targetCol, marked);
					}
				}
			}
		}

		return result;
	}

	private static int solve(int[][] a) {
		int sum = 0;
		int rows = a.length;
		int columns = a[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (a[r][c] == 1) {
					int tmp = solve(a, r, c, new boolean[rows][columns]);
					if (tmp > sum) {
						sum = tmp;
					}
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 1, 0, 0, 1 }, { 1, 0, 0, 0 } };

		System.out.println(solve(a));
	}

}
