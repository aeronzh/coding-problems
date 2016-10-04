package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You are given a square map of size n x n. Each cell of the map has a value
 * denoting its depth. We will call a cell of the map a cavity if and only if
 * this cell is not on the border of the map and each cell adjacent to it has
 * strictly smaller depth. Two cells are adjacent if they have a common side
 * (edge).
 * 
 * You need to find all the cavities on the map and depict them with the
 * uppercase character X.
 * 
 * @author lucas
 *
 */
public class CavityMap {

	private static void solve(char[][] map, int n) {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				char a = map[r][c];
				if (r >= 1 && c >= 1 && r < n - 1 && c < n - 1) {
					if (map[r][c - 1] < a && map[r - 1][c] < a && map[r][c + 1] < a && map[r + 1][c] < a) {
						System.out.print('X');
					} else {
						System.out.print(a);
					}
				} else {
					System.out.print(a);
				}
			}
			System.out.println();
		}


	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		char[][] map = new char[n][n];

		for (int r = 0; r < n; r++) {
			map[r] = in.next().toCharArray();
		}

		solve(map, n);

	}

}
