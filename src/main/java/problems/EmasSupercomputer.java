package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lucas on 12/09/16.
 */
public class EmasSupercomputer {

    private static void solve(char[][] grid, int rows, int cols) {

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        char[][] grid = new char[n][m];

        for (int row = 0; row<n; row++){
            grid[row] = in.next().toCharArray();
        }

        solve(grid, n, m);
    }
}
