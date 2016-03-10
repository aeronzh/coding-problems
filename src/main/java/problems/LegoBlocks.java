package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You have 4 types of lego blocks, of sizes (1 x 1 x 1), (1 x 1 x 2), (1 x 1 x
 * 3), and (1 x 1 x 4). Assume that you have an infinite number of blocks of
 * each type.
 * <p/>
 * Using these blocks, you want to make a wall of height N and width M. The wall
 * should not have any holes in it. The wall you build should be one solid
 * structure. A solid structure can be interpreted in one of the following ways:
 * <p/>
 * (1)It should not be possible to separate the wall along any vertical line
 * without cutting any lego block used to build the wall.
 * <p/>
 * (2)You cannot make a vertical cut from top to bottom without cutting one or
 * more lego blocks.
 * <p/>
 * The blocks can only be placed horizontally. In how many ways can the wall be
 * built?
 * <p/>
 * Input: The first line contains the number of test cases T. T test cases
 * follow. Each case contains two integers N and M.
 * <p/>
 * Output: Output T lines, one for each test case containing the number of ways
 * to build the wall. As the numbers can be very large, output the result modulo
 * 1000000007.
 * <p/>
 * Sample Input:
 * <p/>
 * 4
 * <p/>
 * 2 2
 * <p/>
 * 3 2
 * <p/>
 * 2 3
 * <p/>
 * 4 4
 * <p/>
 * Sample Output:
 * <p/>
 * 3
 * <p/>
 * 7
 * <p/>
 * 9
 * <p/>
 * 3375
 * <p/>
 * Explanation:
 * <p/>
 * - For the first case, we can have two (1 * 1 * 2) lego blocks stacked one on
 * top of another.
 * <p/>
 * - one (1 * 1 * 2) block stacked on top of two (1 * 1 * 1) blocks.
 * <p/>
 * <p/>
 * - two (1 * 1 * 1) blocks stacked on top of one (1 * 1 * 2) block.
 * <p/>
 * **
 * <p/>
 * ##
 * <p/>
 * <p/>
 * or
 * <p/>
 * <p/>
 * ##
 * <p/>
 * +$
 * <p/>
 * <p/>
 * or
 * <p/>
 * <p/>
 * +#
 * <p/>
 * $$
 * <p/>
 * For the second case, each row of the wall can contain either two blocks of
 * width 1, or one block of width 2. However, the wall where all rows contain
 * two blocks of width 1 is not a solid one as it can be divided vertically.
 * Thus, the number of ways is 2 * 2 * 2 - 1 = 7.
 *
 * @author lucas
 */
public class LegoBlocks {
	private static final long MODULO = 1000000007;
	static long[] cache;

	public static long pow(long x, long n, long p) {
		long result = 1;
		while (n > 0) {
			if ((n & 1) == 1) {
				result = (result * x) % p;
			}

			x = (x * x) % p;
			n = n >> 1;
		}

		return result;
	}

	private static long solveSingleRow(int width) {
		if (width == 0) {
			return 1;
		} else if (width < 0) {
			return 0;
		} else {
			if (cache[width] == -1) {
				cache[width] = (solveSingleRow(width - 1) + solveSingleRow(width - 2) + solveSingleRow(width - 3) + solveSingleRow(width - 4)) % MODULO;
			}
			return cache[width];
		}
	}

	private static long[][] solve(int height, int width) {
		// {height, depth, length}
		long[][] a = new long[height + 1][width + 1];
		long[][] s = new long[height + 1][width + 1];
		cache = new long[width + 1];

		for (int w = 0; w <= width; w++) {
			cache[w] = -1;
		}

		for (int w = 1; w <= Math.min(width, 4); w++) {
			s[1][w] = 1;
		}

		for (int h = 1; h <= height; h++) {
			for (int w = 1; w <= width; w++) {
				long oneRow = solveSingleRow(w);
				a[h][w] = pow(oneRow, h, MODULO);
			}

			for (int w = 1; w <= width; w++) {
				long bad = 0;
				for (int l = 1; l <= w - 1; l++) {
					bad += ((s[h][l] * a[h][w - l]) % MODULO);
					bad = bad % MODULO;
				}

				s[h][w] = (a[h][w] - bad) % MODULO;
			}

		}

		return s;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner scanner = new Scanner(System.in);

		int tests = scanner.nextInt();

		long[][] s = solve(1000, 1000);

		for (int t = 0; t < tests; t++) {

			int n = scanner.nextInt();
			int m = scanner.nextInt();
			long result = s[n][m];
			while (result < 0) {
				result = result + MODULO;
			}

			System.out.println(result);
		}

	}

}
