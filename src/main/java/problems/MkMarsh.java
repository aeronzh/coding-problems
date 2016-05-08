package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MkMarsh {
    private static int max = Integer.MIN_VALUE;

    private static final int EMPTY = 0;
    private static final int VISITED = 2;

    private static final int UP = 2;
    private static final int DOWN = 2;
    private static final int LEFT = 2;
    private static final int RIGHT = 2;

    private static void print(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(a[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void solve(int[][] a, int r, int c, int count) {
        int rows = a.length;
        int columns = a[0].length;

        a[r][c] = VISITED;

        if ((r > 0 && c < columns - 1 && a[r - 1][c + 1] == VISITED) && (r > 0 && a[r - 1][c] == VISITED)) {

            // Check rectangle
            int tmp = 0;
            int row = r-1;
            int col = c;
            int up = 0;
            int down = 0;
            int left = 0;
            int right = 0;
            while (col<columns-1 && a[row][col] == VISITED) {
                col++;
                tmp++;
                up++;
            }

            while (row<rows-1 && a[row][col] == VISITED) {
                row++;
                tmp++;
                right++;
            }

            while (col>0 && a[row][col] == VISITED) {
                col--;
                tmp++;
                down++;
            }

            while (row>0 && a[row][col] == VISITED) {
                row--;
                tmp++;
                left++;
            }

            if (up==down && left==right) {
//                System.out.println("End = "+(r-1)+", "+c);
//                System.out.println("up = " + up);
//                System.out.println("right = " + right);
//                System.out.println("down = " + down);
//                System.out.println("left = " + left);
                if (tmp>max) {
                    max = tmp;
                }
            }
        }


        // Go right
        if (c < columns - 1 && a[r][c + 1] == EMPTY) {
            solve(a, r, c + 1, count+1);
        }

        // Go down
        if (r < rows - 1 && a[r + 1][c] == EMPTY) {
            solve(a, r + 1, c, count+1);
        }


        // Go left
        if (c > 0 && a[r][c - 1] == EMPTY) {
            solve(a, r, c - 1, count+1);
        }

        // Go up
        if (r > 0 && a[r - 1][c] == EMPTY) {
            solve(a, r - 1, c, count+1);
        }

        a[r][c] = EMPTY;
    }


    private static void solve(int[][] a) {
        int m = a.length;
        for (int r = 0; r < m; r++) {
            int n = a[r].length;
            for (int c = 0; c < n; c++) {
                if (a[r][c] == EMPTY) {
                    solve(a, r, c, 1);
                }
            }
        }

        if (max>Integer.MIN_VALUE) {
            System.out.println(max);
        } else {
            System.out.println("impossible");
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] a = new int[m][n];
        for (int r = 0; r < m; r++) {
            char[] line = scanner.next().toCharArray();
            for (int c = 0; c < n; c++) {
                if (line[c] == 'x') {
                    a[r][c] = 1;
                }
            }
        }

        solve(a);
//        print(a);
    }
}
