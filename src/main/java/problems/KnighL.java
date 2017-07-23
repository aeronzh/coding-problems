package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://lucaslouca.com/knightl-on-a-chessboard-challenge/
 */
public class KnighL {

    private static int brute(int n, int i, int j, int r, int c, boolean[][] visited, int[][] steps, int count) {
        visited[r][c] = true;

        if (r == n - 1 && c == n - 1) {
            return count;
        } else {
            int[] rows = {r + i, r + i, r - i, r - i, r + j, r + j, r - j, r - j};
            int[] cols = {c + j, c - j, c + j, c - j, c + i, c - i, c + i, c - i};
            int min = Integer.MAX_VALUE;

            for (int rc = 0; rc < 8; rc++) {
                int newRow = rows[rc];
                int newCol = cols[rc];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n) {
                    if (!visited[newRow][newCol] || (visited[newRow][newCol] && steps[newRow][newCol] > count + 1)) {
                        steps[newRow][newCol] = count + 1;

                        int ans = brute(n, i, j, newRow, newCol, visited, steps, count + 1);

                        if (ans != Integer.MAX_VALUE) {
                            if (ans < min) {
                                min = ans;
                            }
                        }

                    }
                }
            }

            return min;
        }
    }


    private static int solve(int n, int i, int j) {
        int[][] steps = new int[n][n];
        int ans = brute(n, i, j, 0, 0, new boolean[n][n], steps, 0);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int ans = solve(n, i, j);
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}
