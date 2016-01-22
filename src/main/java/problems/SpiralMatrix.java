package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, given the following matrix:
 * 
 * [
 * 
 * [ 1, 2, 3, 4, 5 ],
 * 
 * [ 6, 7, 8, 9, 10],
 * 
 * [ 11, 12, 13, 14, 15],
 * 
 * [ 16, 17, 18, 19, 20]
 * 
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author lucas
 *
 */
public class SpiralMatrix {

	public static List<Integer> spiral(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();

		int rows = matrix.length;
		int columns = matrix[0].length;

		int layers = rows / 2;

		for (int l = 0; l < layers; l++) {
			List<Integer> temp = new ArrayList<Integer>();

			for (int r = l; r < rows - l; r++) {
				if (r == l) {
					for (int c = l; c < columns - l; c++) {
						result.add(matrix[r][c]);
					}
				} else if (r == rows - l - 1) {
					for (int c = columns - l - 1; c >= l; c--) {
						result.add(matrix[r][c]);
					}
				} else {
					result.add(matrix[r][columns - l - 1]);
					temp.add(matrix[rows - l - 1 - r][l]);
				}
			}

			result.addAll(temp);
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
		System.out.println(spiral(matrix));
	}

}
