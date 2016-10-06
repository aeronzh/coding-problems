package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Problem Statement
 *
 * A group of farmers has some elevation data, and we're going to help them
 * understand how rainfall flows over their farmland.
 *
 * We'll represent the land as a two-dimensional array of altitudes and use the
 * following model, based on the idea that water flows downhill:
 *
 * If a cell’s four neighboring cells all have higher altitudes, we call this
 * cell a sink; water collects in sinks.
 *
 * Otherwise, water will flow to the neighboring cell with the lowest altitude.
 * If a cell is not a sink, you may assume it has a unique lowest neighbor and
 * that this neighbor will be lower than the cell.
 *
 * Cells that drain into the same sink – directly or indirectly – are said to be
 * part of the same basin.
 *
 * Your challenge is to partition the map into basins. In particular, given a
 * map of elevations, your code should partition the map into basins and output
 * the sizes of the basins, in descending order.
 *
 * Assume the elevation maps are square. Input will begin with a line with one
 * integer, S, the height (and width) of the map. The next S lines will each
 * contain a row of the map, each with S integers – the elevations of the S
 * cells in the row. Some farmers have small land plots such as the examples
 * below, while some have larger plots. However, in no case will a farmer have a
 * plot of land larger than S = 5000.
 *
 * Your code should output a space-separated list of the basin sizes, in
 * descending order. (Trailing spaces are ignored.)
 *
 * @author lucas
 *
 */

// EXAMPLES
//
//Input:                 Output:
//	 3                      7 2
//	 1 5 2
//	 2 4 7
//	 3 6 9
//
//	The basins, labeled with A’s and B’s, are:
//	 A A B
//	 A A B
//	 A A A
//	-----------------------------------------
//	Input:                  Output:
//	 1                       1
//	 10
//
//	There is only one basin in this case.
//	The basin, labeled with A’s is:
//	 A
//	-----------------------------------------
//	Input:                  Output:
//	 5                       11 7 7
//	 1 0 2 5 8
//	 2 3 4 7 9
//	 3 5 7 8 9
//	 1 2 5 4 3
//	 3 3 5 2 1
//
//	The basins, labeled with A’s, B’s, and C’s, are:
//	 A A A A A
//	 A A A A A
//	 B B A C C
//	 B B B C C
//	 B B C C C
//	-----------------------------------------
//	Input:                  Output:
//	 4                       7 5 4
//	 0 2 1 3
//	 2 1 0 4
//	 3 3 3 3
//	 5 5 2 1
//
//	The basins, labeled with A’s, B’s, and C’s, are:
//	 A A B B
//	 A B B B
//	 A B B C
//	 A C C C
//	-----------------------------------------
public class Basins2 {
    private static final int EMPTY = 0;

    private static void print(int[][] a) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[r].length; c++) {
                System.out.print(a[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSink(int r, int c, int[][] map, int n) {
        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if (r > 0) {
            top = map[r - 1][c];
        }

        if (r < n - 1) {
            down = map[r + 1][c];
        }

        if (c > 0) {
            left = map[r][c - 1];
        }

        if (c < n - 1) {
            right = map[r][c + 1];
        }

        int self = map[r][c];

        return self < Math.min(top, Math.min(down, Math.min(left, right)));
    }

    private static int[] lowestNeigbour(int r, int c, int[][] map, int n) {
        int row = r;
        int col = c;
        int min = map[row][col];

        if (r > 0) {
            if (map[r - 1][c] < min) {
                min = map[r - 1][c];
                row = r - 1;
                col = c;
            }
        }

        if (r < n - 1) {
            if (map[r + 1][c] < min) {
                min = map[r + 1][c];
                row = r + 1;
                col = c;
            }
        }

        if (c > 0) {
            if (map[r][c - 1] < min) {
                min = map[r][c - 1];
                row = r;
                col = c - 1;
            }
        }

        if (c < n - 1) {
            if (map[r][c + 1] < min) {
                min = map[r][c + 1];
                row = r;
                col = c + 1;
            }
        }

        return new int[]{row, col};
    }

    private static int dfs(int[][] basins, Map<Integer, Integer> sink2count, int r, int c, int[][] map, int n) {
        if (basins[r][c] != EMPTY) {
            return basins[r][c];
        }

        if (isSink(r, c, map, n)) {
            if (basins[r][c] == EMPTY) {
                // If we have found a new sink, store it.
                basins[r][c] = sink2count.keySet().size() + 1;
                sink2count.put( basins[r][c], 1);
            }

            return basins[r][c];
        } else {
            int[] lowestNeighbour = lowestNeigbour(r, c, map, n);
            if (basins[lowestNeighbour[0]][lowestNeighbour[1]] == EMPTY) {
                basins[r][c] = dfs(basins, sink2count, lowestNeighbour[0], lowestNeighbour[1], map, n);
            } else {
                // Lowest neighbour already has a basin
                basins[r][c] = basins[lowestNeighbour[0]][lowestNeighbour[1]];
            }

            sink2count.put(basins[r][c],sink2count.get(basins[r][c])+1);
            return basins[r][c];
        }
    }


    private static void solve(int[][] map, int n) {
        int[][] basins = new int[n][n];
        Map<Integer, Integer> sink2count = new HashMap<Integer, Integer>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                dfs(basins, sink2count, r, c, map, n);
            }
        }

        print(basins);

        Collection<Integer> values = sink2count.values();
        List<Integer> list = new ArrayList<Integer>(values);
        Collections.sort(list);
        Collections.reverse(list);

        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] map = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                map[r][c] = in.nextInt();
            }
        }

        solve(map, n);
    }
}
