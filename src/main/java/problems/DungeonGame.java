package problems;

/**
 * The purpose of the game is for a Knight(K) to traverse a dungeon full of
 * threats and power-ups to rescue the princess(P).
 * 
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0's) or
 * contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess. For example, given the dungeon below, the
 * initial health of the knight must be at least 7 if he follows the optimal
 * path RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * https://leetcode.com/problems/dungeon-game/
 * 
 * @author lucas
 *
 */

// -2 (K)	-3	   3
// -5	    -10	   1
// 10	     30	  -5 (P)

public class DungeonGame {

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

	/**
	 * Dynamic Programming:
	 * 
	 * 
	 * We start from the bottom right cell: what is the minimum amount of health
	 * the Knight must have before entering the room inorder to retain a health
	 * of 1 after entering the room? ==>
	 * 
	 * dp[rows - 1][cols - 1] = Math.abs(Math.min(dungeon[rows - 1][rows - 1],
	 * 0)) + 1;
	 * 
	 * 
	 * Then initialize the last column:
	 * 
	 * For column=#cols-1 and row=r: How much health must the Knight have before
	 * entering the room, in order to leave the room with the minimum health
	 * required for the next room (column=#cols-1 and row=r+1)? The Knight must
	 * have a health level of at least 1 before entering the room ==>
	 * 
	 * dp[r][cols-1] = Math.max(dp[r + 1][cols - 1] - dungeon[r][cols - 1], 1);
	 * 
	 * 
	 * Then initialize the last row: Similar to last column
	 * 
	 * 
	 * Then iterate inner rooms and choose whether to follow the bottom path or
	 * the path to the right, based on which path requires the minium amount of
	 * health.
	 * 
	 * @param dungeon
	 * @return
	 */
	public static int solve(int[][] dungeon) {
		int rows = dungeon.length;
		int cols = dungeon[0].length;

		int[][] dp = new int[rows][cols];
		dp[rows - 1][cols - 1] = Math.abs(Math.min(dungeon[rows - 1][rows - 1], 0)) + 1;

		// last column
		for (int r = rows - 2; r >= 0; r--) {
			dp[r][cols - 1] = Math.max(dp[r + 1][cols - 1] - dungeon[r][cols - 1], 1);
		}

		// bottom row
		for (int c = cols - 2; c >= 0; c--) {
			dp[rows - 1][c] = Math.max(dp[rows - 1][c + 1] - dungeon[rows - 1][c], 1);
		}

		for (int r = rows - 2; r >= 0; r--) {
			for (int c = cols - 2; c >= 0; c--) {
				if (dp[r + 1][c] < dp[r][c + 1]) {
					dp[r][c] = Math.max(dp[r + 1][c] - dungeon[r][c], 1);
				} else {
					dp[r][c] = Math.max(dp[r][c + 1] - dungeon[r][c], 1);
				}
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(solve(dungeon));
	}

}
