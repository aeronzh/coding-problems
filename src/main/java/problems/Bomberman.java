package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Bomberman lives in a rectangular grid with R rows and C columns. Each cell in
 * the grid either contains a bomb or nothing at all.
 * 
 * Each bomb can be planted in any cell of the grid but, once planted, it will
 * detonate after exactly 3 seconds. Once a bomb detonates, it's destroyed —
 * along with anything in its four neighboring cells. This means that if a bomb
 * detonates in cell i,j, cells (i +- 1, j) and (i, i +- 1) are cleared (note
 * that cells at the edge of the grid have less than four neighboring cells). If
 * there is a bomb in a neighboring cell, the neighboring bomb is destroyed
 * without detonating (i.e., no chain reaction occurs).
 * 
 * Bomberman is immune to bombs, so he can move freely throughout the grid.
 * Here's what he does:
 * 
 * 1. Initially, Bomberman arbitrarily plants bombs in some of the cells.
 * 
 * 2. After one second, Bomberman does nothing.
 * 
 * 3. After one more second, Bomberman plants bombs in all cells without bombs,
 * thus filling the whole grid with bombs. It is guaranteed that no bombs will
 * detonate at this second.
 * 
 * 4. After one more second, any bombs planted exactly three seconds ago will
 * detonate. Here, Bomberman stands back and observes.
 * 
 * 5. Bomberman then repeats steps 3 and 4 indefinitely.
 * 
 * 
 * Note that during every second Bomberman plants bombs, the bombs are planted
 * simultaneously (i.e., at the exact same moment), and any bombs planted at the
 * same time will detonate at the same time.
 * 
 * Given the initial configuration of the grid with the locations of Bomberman's
 * first batch of planted bombs, determine the state of the grid after N
 * seconds.
 * 
 * @author lucas
 *
 */
public class Bomberman {

	/**
	 * Thanks to baranoob from the forums:
	 * 
	 * I solved the problem using the following tricks. I guess my solution is
	 * not perfect but I hope it can help who struggled. Assume using the
	 * following time:
	 * 
	 * N = 0 (initial board - time of bomb is 3)
	 * 
	 * N = 1 (do nothing - time of bomb is reduced to 2)
	 * 
	 * N = 2 (time of existing bombs is reduced to 1, add new bombs to empty
	 * cells with time 3)
	 * 
	 * N = 3 (boms with time 1 will exploded, new boms added in previous steps
	 * have time reduced to 2).
	 * 
	 * I use the following test to illustrate my algorithm.
	 * 
	 * 4 3
	 * 
	 * O..O
	 * 
	 * .O..
	 * 
	 * ....
	 * 
	 * 
	 * 
	 * I convert it to the following arrays in my solution:
	 * 
	 * 3 0 0 3
	 * 
	 * 0 3 0 0
	 * 
	 * 0 0 0 0
	 * 
	 * 
	 * (3 is bomb with time 3. 0 is empty cells i.e has no bombs).
	 * 
	 * 
	 * 
	 * 
	 * Below are some observation:
	 * 
	 * 1/ When N = 4, N = 6, ..., board is full of bombs.
	 * 
	 * 2/ Board at N = 3 is the same with board at N = 7, N = 11
	 * 
	 * 3/ Board at N = 5 is the same with board at N = 9, N = 13
	 * 
	 * 4/ To solve board at N = 3. Calculate board at N = 2
	 * 
	 * 
	 * Given example a board with N = 0 N = 2
	 * 
	 * 3 0 0 3 1 3 3 1
	 * 
	 * 0 3 0 0 -> 3 1 3 3
	 * 
	 * 0 0 0 0 3 3 3 3
	 * 
	 * 
	 * After 1 second (N = 3), cell with 1 will explode to 0 and make neighbour
	 * cells become 0. Cells with 3 become 2.
	 * 
	 * N = 3
	 * 
	 * 0 0 0 0
	 * 
	 * 0 0 0 0
	 * 
	 * 2 0 2 2
	 * 
	 * 
	 * 5/ To solve board at N = 5. Use board at N = 3. N = 3 N = 5
	 * 
	 * 0 0 0 0 2 2 2 2
	 * 
	 * 0 0 0 0 -> 0 2 0 0
	 * 
	 * 2 0 2 2 0 0 0 0
	 * 
	 * Note that cells with 0 become 2 and cells with 2 become 0. This is
	 * because
	 * 
	 * - cells with 0 is empty cells and it will be populated with bombs at
	 * previous step (N = 4).
	 * 
	 * - cells with 2 is bomb cells and it will explode to 0 and make neighbour
	 * cells become 0.
	 * 
	 * @param grid
	 */

	private static void print(char[][] grid) {
		int rows = grid.length;

		for (int r = 0; r < rows; r++) {
			System.out.println(new String(grid[r]));
		}
	}

	private static void printChar(int[][] t) {
		int rows = t.length;
		int cols = t[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (t[r][c] == 0) {
					System.out.print(".");
				} else {
					System.out.print("O");
				}
			}
			System.out.println();
		}
	}

	private static void print(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				System.out.print(grid[r][c] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

	// N=4, 6, 8,... full board
	private static void full(char[][] grid, int rows, int cols) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				grid[r][c] = 'O';
			}
		}
	}

	private static void fill(int[][] t, int rows, int cols) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (t[r][c] > 0) {
					t[r][c] = t[r][c] - 1;
				} else {
					t[r][c] = 3;
				}
			}
		}
	}

	private static int[][] detonate(int[][] t, int rows, int cols) {
		int[][] ans = new int[rows][cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				ans[r][c] = t[r][c] - 1;
				t[r][c] = t[r][c] - 1;
				if (t[r][c] == 0) {

					// detonate
					if (r > 0) {
						if (t[r - 1][c] != 1) {
							ans[r - 1][c] = 0;
							t[r - 1][c] = -1;
						}
					}

					if (r < rows - 1) {
						if (t[r + 1][c] != 1) {
							ans[r + 1][c] = 0;
							t[r + 1][c] = -1;
						}
					}

					if (c > 0) {
						if (t[r][c - 1] != 1) {
							ans[r][c - 1] = 0;
							t[r][c - 1] = -1;
						}
					}

					if (c < cols - 1) {
						if (t[r][c + 1] != 1) {
							ans[r][c + 1] = 0;
							t[r][c + 1] = -1;
						}
					}
				}
			}
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (t[r][c] <= 0) {
					ans[r][c] = 0;
				}
			}
		}

		return ans;
	}

	private static void compute(char[][] grid, int rows, int cols, int n) {
		int[][] t = new int[rows][cols];

		int targetN = 0;

		// initial board (n=0)
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == 'O') {
					t[r][c] = 3;
				}
			}
		}

		// n=1 do nothing
		targetN++;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (t[r][c] > 0) {
					t[r][c] = t[r][c] - 1;
				}
			}
		}

		if (targetN == n) {
			printChar(t);
			return;
		}

		targetN++;
		// n=2, fill empty cells
		fill(t, rows, cols);

		if (targetN == n) {
			printChar(t);
			return;
		}

		// n=3,4,5,...
		final int FILL = 1;
		final int DETONATE = 2;
		int nextStep = DETONATE;

		while (targetN < n) {
			if (nextStep == DETONATE) {
				t = detonate(t, rows, cols);
				nextStep = FILL;
			} else {
				fill(t, rows, cols);
				nextStep = DETONATE;
			}

			targetN++;
		}

		printChar(t);

	}

	private static void solve(char[][] grid, int rows, int cols, int n) {
		if (n == 0 || n == 1) {
			print(grid);
			return;
		}

		// 4, 6, 8, ...
		if (n >= 4 && n % 2 == 0) {
			full(grid, rows, cols);
			print(grid);
			return;
		}

		if (n == 2) {
			compute(grid, rows, cols, 2);

			return;
		}

		// 3, 7, 11, ...
		if (n % 4 == 3) {
			// Compute for n=3
			compute(grid, rows, cols, 3);

			return;
		}

		// 5, 9, 13, ...
		if (n % 4 == 1) {
			// Compute for n=5
			compute(grid, rows, cols, 5);

			return;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int rows = in.nextInt();
		int cols = in.nextInt();
		int n = in.nextInt();

		char[][] grid = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			grid[r] = in.next().toCharArray();
		}

		solve(grid, rows, cols, n);
	}

}
