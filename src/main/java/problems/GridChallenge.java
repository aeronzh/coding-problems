package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a squared sized grid  of size  in which each cell has a lowercase letter. Denote the character in the th row and in the th column as .
 * <p/>
 * You can perform one operation as many times as you like: Swap two column adjacent characters in the same row  and  for all valid .
 * <p/>
 * Is it possible to rearrange the grid such that the following condition is true?
 * <p/>
 * for  and
 * for
 * <p/>
 * In other words, is it possible to rearrange the grid such that every row and every column is lexicographically sorted?
 * <p/>
 * Note: , if letter  is equal to  or is before  in the alphabet.
 * <p/>
 * <p/>
 * Input Format
 * <p/>
 * <p/>
 * The first line begins with , the number of testcases. In each testcase you will be given . The following  lines contain  lowercase english alphabet each, describing the grid.
 * <p/>
 * <p/>
 * <p/>
 * Output Format
 * <p/>
 * <p/>
 * Print  lines. On the th line print YES if it is possible to rearrange the grid in the th testcase or NO otherwise.
 * <p/>
 * Constraints
 * <p/>
 * <p/>
 * will be a lower case letter
 * <p/>
 * Sample Input
 * <p/>
 * 1
 * <p/>
 * 5
 * <p/>
 * ebacd
 * <p/>
 * fghij
 * <p/>
 * olmkn
 * <p/>
 * trpqs
 * <p/>
 * xywuv
 * <p/>
 * <p/>
 * Sample Output
 * <p/>
 * YES
 * <p/>
 * <p/>
 * Explanation
 * <p/>
 * The grid in the first and only testcase can be reordered to
 * <p/>
 * abcde
 * <p/>
 * fghij
 * <p/>
 * klmno
 * <p/>
 * pqrst
 * <p/>
 * uvwxy
 * <p/>
 * <p/>
 * This fulfills the condition since the rows 1, 2, ..., 5 and the columns 1, 2, ..., 5 are all lexicographically sorted.
 */
public class GridChallenge {

    private static void print(char[][] g) {
        int n = g.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static String solve(char[][] g) {
        int n = g.length;

        for (int i = 0; i < n; i++) {
            Arrays.sort(g[i]);
        }


        for (int col = 0; col < n; col++) {
            for (int row = 1; row < n; row++) {
                if (g[row][col]<g[row-1][col]) {
                    return "NO";
                }
            }
        }


        return "YES";
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            char[][] g = new char[n][n];
            for (int i = 0; i < n; i++) {
                g[i] = scanner.next().toCharArray();
            }

            System.out.println(solve(g));
        }
    }
}
