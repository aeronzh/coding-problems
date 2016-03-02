package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You have a rectangular board consisting of N rows, numbered from 11 to N, and
 * M columns, numbered from 11 to M. The top left is (1,1)(1,1) and the bottom
 * right is (N,M)(N,M). Initially - at time 0 - there is a coin on the top-left
 * cell of your board. Each cell of your board contains one of these letters:
 * 
 * : Exactly one of your cells has letter '*'.
 * 
 * U: If at time tt the coin is on cell (i,j)(i,j) and cell (i,j)(i,j) has
 * letter 'U', the coin will be on cell (i−1,j)(i−1,j) at time t+1t+1, if
 * i>1i>1. Otherwise, there is no coin on your board at time t+1t+1.
 * 
 * L: If at time tt the coin is on cell (i,j)(i,j) and cell (i,j)(i,j) has
 * letter 'L', the coin will be on cell (i,j−1)(i,j−1) at time t+1t+1, if
 * j>1j>1. Otherwise, there is no coin on your board at time t+1t+1.
 * 
 * D: If at time tt the coin is on cell (i,j)(i,j) and cell (i,j)(i,j) has
 * letter 'D', the coin will be on cell (i+1,j)(i+1,j) at time t+1t+1, if
 * i<Ni<N. Otherwise, there is no coin on your board at time t+1t+1.
 * 
 * R: If at time tt the coin is on cell (i,j)(i,j) and cell (i,j)(i,j) has
 * letter 'R', the coin will be on cell (i,j+1)(i,j+1) at time t+1t+1, if
 * j<Mj<M. Otherwise, there is no coin on your board at time t+1t+1.
 * 
 * When the coin reaches a cell that has letter '*', it will stay there
 * permanently. When you punch on your board, your timer starts and the coin
 * moves between cells. Before starting the game, you can make operations to
 * change the board, such that you are sure that at or before time KK the coin
 * will reach the cell having letter '*'. In each operation you can select a
 * cell with some letter other than '*' and change the letter to 'U', 'L', 'R'
 * or 'D'. You need to carry out as few operations as possible in order to
 * achieve your goal. Your task is to find the minimum number of operations.
 * 
 * Input: The first line of input contains three integers, N, M, and KK,
 * respectively. The next N lines contain M letters each, describing your board.
 * 
 * Output: Print an integer which represents the minimum number of operations
 * required to achieve your goal. If you cannot achieve your goal, print −1−1.
 *
 */

// Sample input
// 3 3 5
//RRD
//DLL
//*UU

// Sample output: 1
public class CointOnTheTable {

	private static int[][][] dp;

	private static int maxWithoutOverflow(int a, int b) {
		if (a == Integer.MAX_VALUE) {
			return a;
		} else {
			return a+b;
		}
	}
	
	private static int solve(char[][] a, int k, int row, int col) {
		int n = a.length;
		int m = a[0].length;

		if (row < 0 || row >= n || col < 0 || col >= m) {
			return Integer.MAX_VALUE;
		}

		if (k == 0 && a[row][col] != '*') {
			return Integer.MAX_VALUE;
		}

		if (a[row][col] == '*') {
			return 0;
		}

		if (dp[row][col][k] != -1) {
			return dp[row][col][k];
		}

		// We change the value of the cell
		int down = maxWithoutOverflow(solve(a, k - 1, row + 1, col),1);
		int up = maxWithoutOverflow(solve(a, k - 1, row - 1, col),1);
		int right = maxWithoutOverflow(solve(a, k - 1, row, col + 1),1);
		int left = maxWithoutOverflow(solve(a, k - 1, row, col - 1),1);
		int withOp = Math.min(up, Math.min(down, Math.min(left, right)));

		// We follow the value of the cell
		char nextDirection = a[row][col];
		int noOp = Integer.MAX_VALUE;
		if (nextDirection == 'U') {
			noOp = solve(a, k - 1, row - 1, col);
		} else if (nextDirection == 'D') {
			noOp = solve(a, k - 1, row + 1, col);
		} else if (nextDirection == 'R') {
			noOp = solve(a, k - 1, row, col + 1);
		} else if (nextDirection == 'L') {
			noOp = solve(a, k - 1, row, col - 1);
		}

		int min = Math.min(withOp, noOp);
		dp[row][col][k] = min;
		return min;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:/Temp/in.txt"));

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int k = s.nextInt();

		char a[][] = new char[n][m];
		s.nextLine();
		for (int r = 0; r < n; r++) {
			a[r] = s.nextLine().toCharArray();
		}

		// Init dp
		dp = new int[n][m][k + 1];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				for (int j = 0; j <= k; j++) {
					dp[r][c][j] = -1;
				}
			}
		}

		int result = solve(a, k, 0, 0);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

}
