package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Sean invented a game involving a  2nx2n matrix where each cell of the matrix contains an integer. He can reverse any
 * of its rows or columns any number of times, and the goal of the game is to maximize the sum of the elements in the
 * nxn submatrix located in the upper-left corner of the 2nx2n matrix (i.e., its upper-left quadrant).
 * <p>
 * Given the initial configurations for q matrices, help Sean reverse the rows and columns of each matrix in the best
 * possible way so that the sum of the elements in the matrix's upper-left quadrant is maximal. For each matrix, print
 * the maximized sum on a new line.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, q, denoting the number of queries. The subsequent lines describe each of the q
 * queries in the following format:
 * <p>
 * 1. The first line of each query contains an integer, n.
 * <p>
 * 2. Each line i the 2n subsequent lines contains 2n space-separated integers describing the respective values of row i
 * in the matrix.
 * <p>
 * <p>
 * Sample Input
 * <p>
 * 1
 * <p>
 * 2
 * <p>
 * 112 42 83 119
 * <p>
 * 56 125 56 49
 * <p>
 * 15 78 101 43
 * <p>
 * 62 98 114 108
 * <p>
 * <p>
 * <p>
 * Sample Output
 * <p>
 * 414
 * <p>
 * <p>
 * Explanation:
 * <p>
 * Reverse column 2, Reverse row 0. Sum is 119 + 114 + 56 + 125 = 414
 */
public class FlippingTheMatrix {

    /**
     * For every element in the first quadrant, choose the maximum from the 4 possible elements that can take its
     * position.
     * <p>
     * Take, for example, the first element, i.e. 112, in the given matrix. Other than 112 itself, there are only 3
     * possible elements that can take its place (119, 108, and 62), no matter how many flipping operations you perform
     * on the matrix. The same rule applies for all the other elements.
     *
     * @param m
     * @param n
     */
    private static int solve(int[][] m, int n) {
        int sum = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                int ricj = Math.max(m[i][j], Math.max(m[i][2 * n - 1 - j], Math.max(m[2 * n - 1 - i][j], m[2 * n - 1 - i][2 * n - 1 - j])));
                sum += ricj;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int queries = in.nextInt();
        for (int q = 1; q <= queries; q++) {
            int n = in.nextInt();
            int[][] matrix = new int[2 * n][2 * n];

            for (int r = 0; r < 2 * n; r++) {
                for (int c = 0; c < 2 * n; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }

            System.out.println(solve(matrix, n));
        }
    }
}
