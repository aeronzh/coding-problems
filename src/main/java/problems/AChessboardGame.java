package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * 
 * Two players are playing a game on a 15x15 chessboard. The rules of the game are as
 * follows:
 * 
 * The game starts with a single coin located at some x,y coordinate. The coordinate
 * of the upper left cell is (1,1), and the coordinate of the lower right cell is (15,15).
 * In each move, a player must move the coin from cell (x,y) to one of the following
 * locations:
 * 
 * (x-2, y+1)
 * 
 * (x-2, y-1)
 * 
 * (x+1,y-2)
 * 
 * (x-1, y-2)
 * 
 * The players move in alternating turns. The first player who is unable to make a move loses the game.
 * 
 * 
 * @author lucas
 *
 */
public class AChessboardGame {
	private static final String FIRST = "First";
	private static final String SECOND = "Second";

	private static void solve(int x, int y) {
		x = x % 4;
		y = y % 4;
		if ((y == 0) || (y == 3) || (x == 0) || (x == 3)) {
			System.out.println(FIRST);
		} else {
			System.out.println(SECOND);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int x = in.nextInt();
			int y = in.nextInt();

			solve(x, y);
		}
	}
}
