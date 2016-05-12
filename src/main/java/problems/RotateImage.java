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

//   1,  2,  3, 4
//   5,  6,  7, 8
//   9, 10, 11, 12
//  13, 14, 15, 16
public class RotateImage {

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

	private static void rotateMatrix(int[][] matrix) {
		int n = matrix.length;
		int numLayers = n / 2;

		for (int l = 0; l < numLayers; l++) {
			int ext = n - l - 1;

			for (int i = l; i < ext; i++) {
				// left -> top
				int top = matrix[l][i];
				matrix[l][i] = matrix[n - i - 1][l];

				// bottom -> left
				matrix[n - i - 1][l] = matrix[ext][n - i - 1];

				// right -> bottom
				matrix[ext][n - i - 1] = matrix[i][ext];

				// top -> right
				matrix[i][ext] = top;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		//int[][] matrix = { { 6, 7 }, { 10, 11 } };
		print(matrix);
		rotateMatrix(matrix);
		print(matrix);
	}
}
