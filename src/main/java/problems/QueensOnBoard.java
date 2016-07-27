package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Queens on Board
 * 
 * You have an N * M chessboard on which some squares are blocked out. In how
 * many ways can you place one or more queens on the board, such that, no two
 * queens attack each other? Two queens attack each other, if one can reach the
 * other by moving horizontally, vertically, or diagonally without passing over
 * any blocked square. At most one queen can be placed on a square. A queen
 * cannot be placed on a blocked square.
 * 
 * Input Format The first line contains the number of test cases T. T test cases
 * follow. Each test case contains integers N and M on the first line. The
 * following N lines contain M characters each, and represent a board. A '#'
 * represents a blocked square and a '.' represents an unblocked square.
 * 
 * @author lucas
 *
 */
public class QueensOnBoard {
	private static final int MOD = 1000000007;
	private static final int EMPTY = -1;
	private static int count;
	
	/**
	 * @param config
	 *            [i] each element represents a row on the board, and the number
	 *            in that element represents the column position that the queen
	 *            is occupying.
	 * @return
	 */
	private static boolean tryConfig(int[] config, int currentRow) {
		for (int r = 0; r < currentRow; r++) {
			// Check vertical
			if (config[r] == config[currentRow] && config[r]!= EMPTY) {
				return false;
			} else if (Math.abs(config[r] - config[currentRow]) == Math.abs(r - currentRow) && config[r] != EMPTY && config[currentRow] != EMPTY) {
				// Check diagonal
				return false;
			}
		}

		return true;
	}

	private static void solve(int n, int m, char[][] board, int[] config, int currentRow) {
		if (currentRow >= n) {
			count++;
			return;
		} else {
			for (int col = 0; col < m; col++) {
				config[currentRow] = col;
				if (tryConfig(config, currentRow)) {
					solve(n, m, board, config, currentRow+1);
				}
				config[currentRow] = EMPTY;
			}
		}
	}

	// http://penguin.ewu.edu/~trolfe/Queens/OptQueen.html
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = in.nextInt();
			int m = in.nextInt();
			char[][] board = new char[n][m];

			for (int r = 0; r < n; r++) {
				board[r] = in.next().toCharArray();
			}

			count = 0;
			int[] config = new int[n];
			Arrays.fill(config, EMPTY);
			solve(n, m, board, config, 0);
			System.out.println(count);
		}
	}
}
