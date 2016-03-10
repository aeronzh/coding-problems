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
            return solveSingleRow(width - 1) + solveSingleRow(width - 2) + solveSingleRow(width - 3) + solveSingleRow(width - 4);
        }
    }

    /**
     * You have to use dynamic programming to do this. First consider the
     * problem without the constraint and call this A(H, W) (H = height, W =
     * width). You probably noticed that A(H, W) = A(1, W) ^ H. i.e. number of
     * ways to make a single row * number of rows Now let S(W, H) be the number
     * of solid boards (i.e. with the constraing now) S(H,W) = A(H,W) - Sum(S(H,
     * L) * A(H, W - L)) [L = 1 ... W - 1] where S(H, L) * A(H, W - L) is number
     * of non-solid boards with leftmost break at L. i.e. we take the total
     * number of boards and subtrac the number of boards with the leftmost
     * vertical break at L for all possible verticals and we avoid repetition
     * this way as well. Let me know if that explanation helps!
     */
    private static long solve(int height, int width) {
        // {height, depth, length}
        long[][] a = new long[height + 1][width + 1];
        long[][] s = new long[height + 1][width + 1];

        for (int h = 1; h <= height; h++) {
            for (int w = 1; w <= width; w++) {
                a[h][w] = pow(solveSingleRow(w), h, MODULO);
            }

            for (int w = 1; w <= width; w++) {
                long bad = 0;
                for (int l = 1; l <= width - 1; l++) {
                    bad += (s[h][l] * a[h][width - l]);
                }
                s[h][w] = a[h][w] - bad;
            }
        }

        return s[height][width];
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(solve(n,m));
        }
    }

}
