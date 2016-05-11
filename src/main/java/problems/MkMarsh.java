package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Mr K has a rectangular land of size m×nm×n. There are marshes in the land
 * where the fence cannot hold. Mr K wants you to find the perimeter of the
 * largest rectangular fence that can be built on this land.
 * 
 * Input format
 * 
 * The first line contains mm and nn. The next mm lines contain nn characters
 * each describing the state of the land. 'x' (ascii value: 120) if it is a
 * marsh and '.' ( ascii value:46) otherwise.
 * 
 * Constraints
 * 
 * 2≤m,n≤500
 * 
 * Output Format
 * 
 * Output contains a single integer - the largest perimeter. If the rectangular
 * fence cannot be built, print "impossible" (without quotes).
 * 
 * Sample Input:
 * 
 * 4 5
 * 
 * .....
 * 
 * .x.x.
 * 
 * .....
 * 
 * .....
 * 
 * 
 * Output
 * 
 * 14
 * 
 * Fence can be put up across the entire land owned by Mr K. The perimeter is
 * 2∗(4−1)+2∗(5−1)=142∗(4−1)+2∗(5−1)=14.
 * 
 * 
 * 
 * Sample Input:
 * 
 * 2 2
 * 
 * .x
 * 
 * x.
 * 
 * Output
 * 
 * impossible
 * 
 * 
 * We need minimum of 4 points to place the 4 corners of the fence. Hence,
 * impossible.
 * 
 * Sample Input:
 * 
 * 2 5
 * 
 * .....
 * 
 * xxxx.
 * 
 * 
 * 
 * Output
 * 
 * impossible
 * 
 * @author lucas
 *
 */
public class MkMarsh {

	// For any given input, if we create matrices (2D arrays) which store the maximum number of squares in any 
	// given direction without marsh with respect to current square, then just by checking the values in the 
	// matrices we would know how far is the mesh. The matrices (up and left) for the sample inputs would be :
	// 	Input             Up matrix             Left matrix
	// 
	// 	2 2
	// 	.x                   0 -1                    0 -1
	// 	x.                  -1  0                   -1  0
	// 
	// 
	// 	4 5
	// 	.....           0  0  0  0  0           0  1  2  3  4
	// 	.x.x.           1 -1  1 -1  1           0 -1  0 -1  0
	// 	.....           2  0  2  0  2           0  1  2  3  4
	// 	.....           3  1  3  1  3           0  1  2  3  4
	// 
	// The matrices above have -1 if the square has marsh, otherwise the value gives the number of steps we can 
	// take in respective directions without hitting the marsh. If we choose one corner for the fence, say bottom-right, 
	// the Up-matrix lets us know how far we can go upwards and the Left-matrix tells how far we can go towards left 
	// without hitting the marsh.
	// 
	// Thus, pre-calculating these matrices once, allows us to check just the corners of possible fence, reducing a lot of 
	// computations at every step.

	private static final int MARSH = 1;

	private static void print(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(a[r][c] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

	private static int[][] preComputeUpMatrix(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		int[][] up = new int[m][n];

		for (int c = 0; c < n; c++) {
			if (a[0][c] == MARSH) {
				up[0][c] = -1;
			}
		}

		for (int r = 1; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (a[r][c] == MARSH) {
					up[r][c] = -1;
				} else {
					up[r][c] = up[r - 1][c] + 1;
				}
			}
		}

		return up;
	}

	private static int[][] preComputeDownMatrix(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		int[][] down = new int[m][n];

		for (int r = 0; r < m; r++) {
			if (a[r][0] == MARSH) {
				down[r][0] = -1;
			}
		}

		for (int r = m - 2; r >= 0; r--) {
			for (int c = n - 1; c >= 0; c--) {
				if (a[r][c] == MARSH) {
					down[r][c] = -1;
				} else {
					down[r][c] = down[r + 1][c] + 1;
				}
			}
		}

		return down;
	}

	private static int[][] preComputeLeftMatrix(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		int[][] left = new int[m][n];

		for (int r = 0; r < m; r++) {
			if (a[r][0] == MARSH) {
				left[r][0] = -1;
			}
		}

		for (int r = 0; r < m; r++) {
			for (int c = 1; c < n; c++) {
				if (a[r][c] == MARSH) {
					left[r][c] = -1;
				} else {
					left[r][c] = left[r][c - 1] + 1;
				}
			}
		}

		return left;
	}

	private static int[][] preComputeRightMatrix(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		int[][] right = new int[m][n];

		for (int r = 0; r < m; r++) {
			if (a[r][n - 1] == MARSH) {
				right[r][n - 1] = -1;
			}
		}

		for (int r = m - 1; r >= 0; r--) {
			for (int c = n - 2; c >= 0; c--) {
				if (a[r][c] == MARSH) {
					right[r][c] = -1;
				} else {
					right[r][c] = right[r][c + 1] + 1;
				}
			}
		}

		return right;
	}

	private static void solve(int[][] a) {
		int[][] up = preComputeUpMatrix(a);
		int[][] left = preComputeLeftMatrix(a);
		int[][] right = preComputeRightMatrix(a);
		int[][] down = preComputeDownMatrix(a);

		int m = a.length;
		int n = a[0].length;

		int max = Integer.MIN_VALUE;
		for (int row = m - 1; row >= 0; row--) {
			for (int col = n - 1; col >= 0; col--) {
				if (a[row][col] != MARSH) {
					int u = up[row][col];
					int l = left[row][col];

					for (int tu = 1; tu <= u; tu++) {
						for (int tl = 1; tl <= l; tl++) {
							int d = down[row - tu][col - tl];
							int r = right[row - tu][col - tl];
							if (d >= tu && r >= tl) {
								int tmp = 2 * tu + 2 * tl;
								if (tmp > max) {
									max = tmp;
								}
							}
						}
					}
				}
			}
		}

		if (max > Integer.MIN_VALUE) {
			System.out.println(max);
		} else {
			System.out.println("impossible");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		int[][] a = new int[m][n];
		for (int r = 0; r < m; r++) {
			char[] line = scanner.next().toCharArray();
			for (int c = 0; c < n; c++) {
				if (line[c] == 'x') {
					a[r][c] = MARSH;
				}
			}
		}

		solve(a);
	}
}
