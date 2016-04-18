package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HexagonalGrid {
	private static final String NO = "NO";
	private static final String YES = "YES";

	private static void print(int[][] a) {
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++) {
				System.out.print(a[r][c]);
			}
			System.out.println();
		}
		System.out.println();

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

				if (offRow < rows && offCol < columns && offRow >= 0 && offCol >= 0 && (offRow != r && offCol != c) && a[offRow][offCol] != 1) {
					neighbors.add(new Integer[] { offRow, offCol });
				}
			}
		}

		return neighbors;
	}

	//0100001
	//1000010

	//#100001
	//1#00010
	private static String solve(int[][] a, int r, int c) {
		print(a);

		if (isFilled(a)) {
			return YES;
		} else {
			String result = NO;

			// Back slash: '\'
			if (r == 0 && c < a[0].length - 1 && a[r + 1][c + 1] != 1) {
				a[r][c] = 1;
				int tmp = a[r + 1][c + 1];
				a[r + 1][c + 1] = 1;
				List<Integer[]> neighbors = getAvailableNeighbors(a, (r + 1), (c + 1));
				for (Integer[] neighbor : neighbors) {
					result = solve(a, neighbor[0], neighbor[1]);
					if (YES.equals(result)) {
						return YES;
					}
				}
				a[r + 1][c + 1] = tmp;
				a[r][c] = 0;
			}

			if (r == 1 && c > 0 && a[r - 1][c - 1] != 1) {
				a[r][c] = 1;
				int tmp = a[r - 1][c - 1];
				a[r - 1][c - 1] = 1;
				List<Integer[]> neighbors = getAvailableNeighbors(a, (r - 1), (c - 1));
				for (Integer[] neighbor : neighbors) {
					result = solve(a, neighbor[0], neighbor[1]);
					if (YES.equals(result)) {
						return YES;
					}
				}
				a[r - 1][c - 1] = tmp;
				a[r][c] = 0;
			}

			// Forward slash: '/'
			if (r == 0 && c > 0 && a[r + 1][c - 1] != 1) {
				a[r][c] = 1;
				int tmp = a[r + 1][c - 1];
				a[r + 1][c - 1] = 1;
				List<Integer[]> neighbors = getAvailableNeighbors(a, (r + 1), (c - 1));
				for (Integer[] neighbor : neighbors) {
					result = solve(a, neighbor[0], neighbor[1]);
					if (YES.equals(result)) {
						return YES;
					}
				}
				a[r + 1][c - 1] = tmp;
				a[r][c] = 0;
			}

			if (r == 1 && c < a[0].length - 1 && a[r - 1][c + 1] != 1) {
				a[r][c] = 1;
				int tmp = a[r - 1][c + 1];
				a[r - 1][c + 1] = 1;
				List<Integer[]> neighbors = getAvailableNeighbors(a, (r - 1), (c + 1));
				for (Integer[] neighbor : neighbors) {
					result = solve(a, neighbor[0], neighbor[1]);
					if (YES.equals(result)) {
						return YES;
					}
				}
				a[r - 1][c + 1] = tmp;
				a[r][c] = 1;
			}

			// Horizontal: '--'
			if (c < a[0].length - 1 && a[r][c + 1] != 1) {
				a[r][c] = 1;
				int tmp = a[r][c + 1];
				a[r][c + 1] = 1;
				List<Integer[]> neighbors = getAvailableNeighbors(a, (r), (c + 1));
				for (Integer[] neighbor : neighbors) {
					result = solve(a, neighbor[0], neighbor[1]);
					if (YES.equals(result)) {
						return YES;
					}
				}
				a[r][c + 1] = tmp;
				a[r][c] = 0;
			}

			if (c > 0 && a[r][c - 1] != 1) {
				a[r][c] = 1;
				int tmp = a[r][c - 1];
				a[r][c - 1] = 1;
				List<Integer[]> neighbors = getAvailableNeighbors(a, (r), (c - 1));
				for (Integer[] neighbor : neighbors) {
					result = solve(a, neighbor[0], neighbor[1]);
					if (YES.equals(result)) {
						return YES;
					}
				}
				a[r][c - 1] = tmp;
				a[r][c] = 0;
			}

			return result;
		}

	}

	private static String solve(int[][] a) {
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a.length; c++) {
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
			int[][] a = new int[2][n + 1];

			String line = scanner.next();
			char[] splitted = line.toCharArray();
			for (int i = 0; i < splitted.length; i++) {
				a[0][i] = splitted[i] - '0';
			}
			a[0][n] = 1;

			line = scanner.next();
			splitted = line.toCharArray();
			for (int i = 0; i < splitted.length; i++) {
				a[1][i + 1] = splitted[i] - '0';
			}
			a[1][0] = 1;

			System.out.println(solve(a));
		}

	}

}
