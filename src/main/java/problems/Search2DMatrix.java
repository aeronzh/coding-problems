package problems;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has properties:
 * 
 * 1) Integers in each row are sorted from left to right. 2) The first integer
 * of each row is greater than the last integer of the previous row.
 * 
 * For example, consider the following matrix:
 * 
 * [
 * 
 * [1, 3, 4, 5],
 * 
 * [6, 7, 8, 9],
 * 
 * [10, 11, 16, 20],
 * 
 * [23, 30, 34, 50]
 * 
 * ]
 * 
 * Given target = 3, return true.
 * 
 * @author lucas
 *
 */
public class Search2DMatrix {

	private static int findRow(int[][] matrix, int n, int startRow, int endRow) {
		int numOfCols = matrix[0].length;

		if (startRow <= endRow) {
			int middleRow = (startRow + endRow) / 2;

			if (n >= matrix[middleRow][0] && n <= matrix[middleRow][numOfCols - 1]) {
				// found
				return middleRow;
			} else if (n < matrix[middleRow][0]) {
				// go up
				return findRow(matrix, n, 0, middleRow - 1);
			} else if (n > matrix[middleRow][numOfCols - 1]) {
				// go down
				return findRow(matrix, n, middleRow + 1, endRow);
			} else {
				return -1;
			}
		}

		return -1;

	}

	private static int findInRow(int[][] matrix, int n, int row, int startCol, int endCol) {
		int numOfCols = matrix[row].length;

		if (startCol <= endCol) {
			int middle = (startCol + endCol) / 2;

			if (matrix[row][middle] == n) {
				return middle;
			} else if (matrix[row][middle] > n) {
				// got left
				return findInRow(matrix, n, row, startCol, middle - 1);
			} else {
				// got right
				return findInRow(matrix, n, row, middle + 1, endCol);
			}
		} else {
			return -1;
		}
	}

	private static int searchValue(int[][] matrix, int n) {
		// Do a divide and conquer to find the correct row.
		int row = findRow(matrix, n, 0, matrix.length);
		System.out.println("Row: " + row);
		return findInRow(matrix, n, row, 0, matrix[row].length);
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 4, 5 }, { 6, 7, 8, 9 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println("Col: " + searchValue(matrix, 3));

	}

}
