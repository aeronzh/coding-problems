package problems;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * @author lucas
 *
 */

//1,  2,  3, 4
//5,  0,  7, 8
//9, 10, 11, 12
//13, 14, 0, 16
public class SetMatrixZeroes {

	private static void print(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int c = 0; c < n; c++) {
				System.out.print(matrix[i][c] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

	private static void zero(int[][] matrix) {
		boolean foundInRow = false;
		boolean foundInCol = false;

		int rows = matrix.length;
		int cols = matrix.length;
		int lastRow = -1;
		int lastCol = -1;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (matrix[r][c] == 0) {
					// zero out out everything in that column until that row
					for (int r2 = 0; r2 < r; r2++) {
						matrix[r2][c] = 0;
					}

					// zero out everything in that row until that colunm
					for (int c2 = 0; c2 < c; c2++) {
						matrix[r][c2] = 0;
					}

					foundInRow = true;
				} else if ((r > 0 && matrix[r - 1][c] == 0) || (c > 0 && matrix[r][c - 1] == 0)) {
					//matrix[r][c] = 0;
				}
			}

		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 0, 1 } };
		print(matrix);
		zero(matrix);
		print(matrix);
	}

}
