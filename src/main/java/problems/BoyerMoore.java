package problems;

import java.util.Arrays;

public class BoyerMoore {
	private static void print(int[][] matrix) {
		int n = matrix.length;
		int k = matrix[0].length;

		for (int i = 0; i < n; i++) {
			for (int c = 0; c < k; c++) {
				System.out.print(matrix[i][c] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

	/**
	 * Simple constant-time lookup solution is as follows: create a 2D table
	 * which is indexed first by the index of the character c in the alphabet
	 * and second by the index i in the pattern. This lookup will return the
	 * occurrence of c in P with the next-highest index j<i or -1 if there is no
	 * such occurrence. The proposed shift will then be i-j, with O(1) lookup
	 * time and O(kn) space, assuming a finite alphabet of length k.
	 * 
	 * 
	 * @param p
	 *            patern
	 * @return lookup table
	 */
	private static int[][] preprocess(String p) {
		final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int k = alphabet.length();
		int n = p.length();
		int[][] lookup = new int[k][n];
		for (int[] row: lookup)
		    Arrays.fill(row, -1);
		

		// bcdad
		for (int index = 0; index < n; index++) {
			char c = p.charAt(index);
			lookup[c - 65][index] = index;
		
		}

		return lookup;
	}

	public static void search(String p, String text, int[][] lookup) {
		int n = p.length();
		int m = text.length();

		int ti = n - 1;
		while (ti < m) {

			int pi = n - 1;
			while (text.charAt(ti) == p.charAt(pi)) {
				pi--;
				ti--;
				if (pi < 0) {
					System.out.println("Found at " + ti);
					return;
				}
			}

			// Not found. Get next-highest index pj<pi in P for the character in Text at which the comparison process failed
			// and shift ti by pi-pj and repeat
			int pj = Math.max(0, lookup[text.charAt(ti)][pi]);			
			ti += (pi-pj);
			
		}
	}

	public static void main(String[] args) {
		int[][] lookup = preprocess("bcdad");
		print(lookup);
	}

}
