package problems;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author lucas
 *
 */

//1,  2,  3, 4
//5,  6,  7, 8
//9, 10, 11, 12
//13, 14, 15, 16
public class RotateMatrix {

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

	private static void rotate(int[][] matrix) {
		int n = matrix.length;
		int layers = n / 2;

		for (int l = 0; l < layers; l++) {
			for (int i = l; i < n - l - 1; i++) {
				int top = matrix[l][i];
				//left goes to top
				matrix[l][i] = matrix[n - i - 1][l];

				// bottom goes to left
				matrix[n - i - 1][l] = matrix[n - l - 1][n - i - 1];

				//right goes to bottom
				matrix[n - l - 1][n - i - 1] = matrix[i][n - l - 1];

				// top goes to right
				matrix[i][n - l - 1] = top;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(matrix);
		rotate(matrix);
		print(matrix);

	}

}
