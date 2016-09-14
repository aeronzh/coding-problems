package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WoC_23_2 {

    private static boolean cross(char[][] grid, int n, int row, int col, int radius) {
        // Check length first

        // up
        if (row - radius < 0) {
            return false;
        }

        // down
        if (row + radius > n - 1) {
            return false;
        }

        // left
        if (col - radius < 0) {
            return false;
        }

        // right
        if (col + radius > n - 1) {
            return false;
        }

        // Check if cells are free
        // go up
        int r = 0;
        while (r <= radius) {
            if (grid[row - r][col] == '*') {
                return false;
            }
            r++;
        }

        // go down
        r = 0;
        while (r <= radius) {
            if (grid[row + r][col] == '*') {
                return false;
            }
            r++;
        }

        // go left
        r = 0;
        while (r <= radius) {
            if (grid[row][col - r] == '*') {
                return false;
            }
            r++;
        }

        // go right
        r = 0;
        while (r <= radius) {
            if (grid[row][col + r] == '*') {
                return false;
            }
            r++;
        }

        return true;
    }

    private static double distance(int r1, int c1, int r2, int c2) {
        return Math.sqrt((r1 - r2) * (r1 - r2) - (c1 - c2) * (c1 - c2));
    }

    private static boolean arround(char[][] grid, int n, int row, int col, int radius) {
        // Check if cells are free
        for (int r = row - radius; r <= row + radius; r++) {
            for (int c = col - radius; c <= col + radius; c++) {
                if (distance(row, col, r, c) <= radius && grid[r][c] == '*') {
                    return false;
                }
            }
        }

        return true;
    }

    private static void solve(char[][] grid, int n) {
        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int min = Math.min(col, Math.min(row, Math.min(n - col - 1, n - row - 1)));
                for (int radius = 0; radius <= min; radius++) {
                    if (grid[row][col] != '*' && arround(grid, n, row, col, radius)) {
                        max = Math.max(max, radius);
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        char[][] grid = new char[n][n];

        for (int row = 0; row < n; row++) {
            grid[row] = in.next().toCharArray();
        }

        solve(grid, n);
    }
}
