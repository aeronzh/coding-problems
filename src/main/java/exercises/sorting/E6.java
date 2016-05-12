package exercises.sorting;

/**
 * Given a matrix in which each row and each column is sorted, write a method to
 * find an element in it.
 * 
 * @author lucas
 *
 */

// 1  2  3 10
// 4  7  8 15
// 5 11 20 34
// 6 16 21 50
//
public class E6 {

	/**
	 * Start in the bottom-left corner of your matrix. Then go to the right
	 * until you find the exact number (done), or until you find a number that
	 * is greater.
	 * 
	 * Then you go upwards in the matrix until you find the exact number (done),
	 * or until you find a number that is smaller.
	 * 
	 * Then again you move to the right, ... and so on until you found the
	 * number or until you reach the right-side or top of your matrix.
	 * 
	 * @param matrix
	 * @param num
	 * @param curRow
	 * @param curCol
	 */
	public static void find(int[][] matrix, int num, int curRow, int curCol) {
		if (curRow >= 0 && curCol < matrix[0].length) {
			if (num == matrix[curRow][curCol]) {
				System.out.println("Found at: " + curRow + ", " + curCol);
			} else if (num > matrix[curRow][curCol]) {
				// go right
				find(matrix, num, curRow, (curCol + 1));
			} else if (num < matrix[curRow][curCol]) {
				// go up
				find(matrix, num, (curRow - 1), curCol);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 10 }, { 4, 7, 8, 15 }, { 5, 11, 20, 34 }, { 6, 16, 21, 50 } };

		// Lower left corner
		int startRow = matrix.length - 1;
		int startCol = 0;

		int num = 20;
		find(matrix, num, startRow, startCol);
	}
}
