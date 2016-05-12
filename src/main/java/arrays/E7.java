package arrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column is set to 0.
 * 
 * @author Lucas L.
 *
 */
public class E7 {

	public static void zero(int[][] matrix) {
		boolean[][] zeros = new boolean[matrix.length][matrix[0].length];

		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (matrix[r][c] == 0) {
					zeros[r][c] = true;
				}
			}
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (zeros[r][c]) {
					for (int tempRow = 0; tempRow < rows; tempRow++) {
						matrix[tempRow][c] = 0;
					}

					for (int tempCol = 0; tempCol < cols; tempCol++) {
						matrix[r][tempCol] = 0;
					}
				}
			}
		}
	}

	/**
	 * Helper method to print an NxM array of ints
	 * 
	 * @param array
	 *            int[][] array
	 */
	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
		print(array);
		zero(array);
		print(array);
	}

}
