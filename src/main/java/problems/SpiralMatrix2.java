package problems;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n^2 in spiral order. For example, given n = 4
 * 
 * 
 * [1,  2,  3,  4],
 * 
 * [12, 13, 14, 5],
 * 
 * [11, 16, 15, 6],
 * 
 * [10, 9,  8,  7]
 * 
 * 
 *  1 2 3
 *  8 9 4
 *  7 6 5  
 * @author lucas
 *
 */
public class SpiralMatrix2 {

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
	
	
	public static void solve(int n) {
		int[][] matrix = new int[n][n];
		int layers = (int) Math.ceil((double)n/2.0);
		int count = 1;
		for (int l=0; l<layers; l++) {
			// top row
			for (int c=l; c<n-l; c++) {
				matrix[l][c] = count++;
			}
			
			//right column
			for (int r=l+1; r<n-l; r++) {
				matrix[r][n-l-1] = count++;
			}
			
			// bottom row
			for (int c=n-l-2; c>=l; c--) {
				matrix[n-l-1][c] = count++;
			}
			
			// left column
			for (int r=n-l-2; r>l; r--) {
				matrix[r][l] = count++;
			}	
		}
		
		print(matrix);
		
	}
	
	public static void main(String[] args) {
		solve(4);

	}

}
