package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * You are given a hexagonal grid of size 2xN. Your task is to construct the
 * grid with 2x1 dominoes. The dominoes can be arranged in any of the three
 * orientations shown below. To add to the woes, certain cells of the hexagonal
 * grid are blackened i.e., no domino can occupy that cell. Can you construct
 * such a hexagonal grid? The blackened cell and the 3 dominoes are shown in the
 * figure below.
 * 
 * 
 * 
 * Input Format The first line contains a single integer T, the number of
 * testcases. T testcases follow. Each testcase contains three lines. The first
 * line of the testcase contains a single integer N, size of the hexagonal grid.
 * The next two lines describe the grid and have N characters each (0
 * corresponds to cell to be filled with domino and 1 corresponds to blackened
 * cell).
 * 
 * Output Format For each testcase output YES if there exists at least one way
 * to fill structure with dominoes and output NO otherwise.
 * 
 * Constraints
 * 
 * 
 * 1 ≤ T ≤ 100
 * 
 * 
 * 1 ≤ N ≤ 10
 * 
 * Note There must be no domino above black cells. All other cells should have
 * only one domino above it.
 * 
 * @author lucas
 *
 */
public class HexagonalGrid {
	private static final String NO = "NO";
	private static final String YES = "YES";
	private static final int EMPTY = 0;
	private static final int BACK_SLASH = 1;
	private static final int FORWARD_SLASH = 1;
	private static final int HORIZONTAL = 1;

	private static void print(int[][] a) {
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++) {
				System.out.print(a[r][c]);
			}
			System.out.println();
		}
	}

	private static boolean isFilled(int[][] a) {
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++) {
				if (a[r][c] != 1) {
					return false;
				}
			}
		}

		return true;
	}

	private static List<Integer[]> getAvailableNeighbors(int[][] a, int r, int c) {
		List<Integer[]> neighbors = new ArrayList<Integer[]>();
		int rows = 2;
		int columns = a[0].length;

		int[] offsets = { -1, 0, 1 };

		for (int rowOff : offsets) {
			int offRow = r + rowOff;
			for (int colOff : offsets) {
				int offCol = c + colOff;

				if (offRow < rows && offCol < columns && offRow >= 0 && offCol >= 0 && (offRow != r && offCol != c) && a[offRow][offCol] == EMPTY) {
					neighbors.add(new Integer[] { offRow, offCol });
				}
			}
		}

		return neighbors;
	}

	private static String solve(int[][] a, int r, int c) {
		//		print(a);
		//		System.out.println();

		if (isFilled(a)) {
			return YES;
		} else {
			String result = NO;

			// Back slash: '\'
			if (r == 0 && c < a[0].length && a[r + 1][c] == EMPTY) {
				a[r][c] = BACK_SLASH;
				a[r + 1][c] = BACK_SLASH;
				result = solve(a);
				if (YES.equals(result)) {
					return YES;
				}
				a[r + 1][c] = EMPTY;
				a[r][c] = EMPTY;
			}

			if (r == 1 && c > 0 && a[r - 1][c] == EMPTY) {
				a[r][c] = BACK_SLASH;
				a[r - 1][c] = BACK_SLASH;
				result = solve(a);
				if (YES.equals(result)) {
					return YES;
				}
				a[r - 1][c] = EMPTY;
				a[r][c] = EMPTY;
			}

			// Forward slash: '/'
			if (r == 0 && c > 0 && a[r + 1][c - 1] == EMPTY) {
				a[r][c] = FORWARD_SLASH;
				a[r + 1][c - 1] = FORWARD_SLASH;
				result = solve(a);
				if (YES.equals(result)) {
					return YES;
				}
				a[r + 1][c - 1] = EMPTY;
				a[r][c] = EMPTY;
			}

			if (r == 1 && c < a[0].length - 1 && a[r - 1][c] == EMPTY) {
				a[r][c] = FORWARD_SLASH;
				a[r - 1][c] = FORWARD_SLASH;
				result = solve(a);
				if (YES.equals(result)) {
					return YES;
				}
				a[r - 1][c] = EMPTY;
				a[r][c] = EMPTY;
			}

			// Horizontal: '--'
			if (c < a[0].length - 1 && a[r][c + 1] == EMPTY) {
				a[r][c] = HORIZONTAL;
				a[r][c + 1] = HORIZONTAL;
				result = solve(a);
				if (YES.equals(result)) {
					return YES;
				}
				a[r][c + 1] = EMPTY;
				a[r][c] = EMPTY;
			}

			if (c > 0 && a[r][c - 1] != 1) {
				a[r][c] = HORIZONTAL;
				a[r][c - 1] = HORIZONTAL;
				result = solve(a);
				if (YES.equals(result)) {
					return YES;
				}
				a[r][c - 1] = EMPTY;
				a[r][c] = EMPTY;
			}

			return result;
		}

	}

	private static String solve(int[][] a) {
		if (isFilled(a)) {
			return YES;
		}

		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++) {
				if (a[r][c] != 1) {
					String result = solve(a, r, c);
					if (YES.equals(result)) {
						return YES;
					}
				}
			}
		}

		return NO;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int tests = scanner.nextInt();

		for (int t = 0; t < tests; t++) {
			int n = scanner.nextInt();
			int[][] a = new int[2][n];

			for (int i = 0; i < a[0].length; i++) {
				a[0][i] = 1;
				a[1][i] = 1;
			}

			String line = scanner.next();
			char[] splitted = line.toCharArray();
			for (int i = 0; i < splitted.length; i++) {
				a[0][i] = splitted[i] - '0';
			}

			line = scanner.next();
			splitted = line.toCharArray();
			for (int i = 0; i < splitted.length; i++) {
				a[1][i] = splitted[i] - '0';
			}

			String result = solve(a);
			String expected = outputScanner.next();

			if (!expected.equals(result)) {
				System.out.println("Got " + result + " expected " + expected);
			} else {
				System.out.println(result);
			}
		}

	}

}
