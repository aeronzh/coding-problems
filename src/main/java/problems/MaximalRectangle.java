package problems;

import java.util.List;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 *
 * @author lucas
 */

// 1 1 1 0
// 1 1 1 1
// 1 1 1 1
// 0 1 0 1

public class MaximalRectangle {
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

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


    public static List<Integer[]> solve(int[][] matrix) {
        LargestRectangleInHistogram hist = new LargestRectangleInHistogram();

        int rows = matrix.length;
        int cols = matrix[0].length;

        int max = -1;
        for (int r = rows - 1; r >= 0; r--) {
            int[] array = new int[cols];
            for (int c = 0; c < cols; c++) {
                int i = r;
                while (i >= 0 && matrix[i][c] != 0) {
                    array[c] += matrix[i][c];
                    i--;
                }
            }
            max = Math.max(max, hist.largestRectangleArea(array));
        }

        System.out.println(max);

        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 0, 1}};
        // row 1-3, col 2-3 ==> [(1,2),(3,3)]

        solve(matrix);
    }

}
