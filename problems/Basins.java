package com.lucaslouca.other;

import java.util.HashMap;
import java.util.Map;

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
public class Basins {
	private static Map<String, Integer> buildSinkMap(int[][] map) {
		Map<String, Integer> sink2count = new HashMap<String, Integer>();

		int n = map.length;

		// find all sinks
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int elevation = map[r][c];
				boolean isSink = true;

				// top left
				if (r > 0 && c > 0) {
					isSink = isSink && (elevation < map[r - 1][c - 1]);
				}

				// top
				if (r > 0) {
					isSink = isSink && (elevation < map[r - 1][c]);
				}

				// top right
				if (r > 0 && c < n - 1) {
					isSink = isSink && (elevation < map[r - 1][c + 1]);
				}

				// left
				if (c > 0) {
					isSink = isSink && (elevation < map[r][c - 1]);
				}

				// right
				if (c < n - 1) {
					isSink = isSink && (elevation < map[r][c + 1]);
				}

				//bottom left
				if (r < n - 1 && c > 0) {
					isSink = isSink && (elevation < map[r + 1][c - 1]);
				}

				// bottom
				if (r < n - 1) {
					isSink = isSink && (elevation < map[r + 1][c]);
				}

				//bottom right
				if (r < n - 1 && c < n - 1) {
					isSink = isSink && (elevation < map[r + 1][c + 1]);
				}

				if (isSink) {
					sink2count.put(r + "," + c, 0);
				}
			}
		}

		return sink2count;
	}

	private static int[] lowestNeighborOf(int[][] map, int r, int c) {
		int[] rowcol = new int[2];

		int n = map.length;
		int elevation = map[r][c];
		int min = elevation;
		int row = r;
		int col = c;

		// top
		if (r > 0 && map[r - 1][c] < min) {
			min = map[r - 1][c];
			row = r - 1;
			col = c;
		}

		// left
		if (c > 0 && map[r][c - 1] < min) {
			min = map[r][c - 1];
			row = r;
			col = c - 1;
		}

		// right
		if (c < n - 1 && map[r][c + 1] < min) {
			min = map[r][c + 1];
			row = r;
			col = c + 1;
		}

		// bottom
		if (r < n - 1 && map[r + 1][c] < min) {
			min = map[r + 1][c];
			row = r + 1;
			col = c;
		}

		rowcol[0] = row;
		rowcol[1] = col;

		return rowcol;
	}

	/**
	 * 7:10 If a cell's four neighboring cells all have higher altitudes, we
	 * call this cell a sink.
	 * 
	 * Water will flow to the neighboring cell with the lowest altitude.
	 * 
	 * @param map
	 * @return
	 */
	public static String basins(int[][] map, Map<String, Integer> sink2count, int r, int c) {
		// find lowest neighbor
		int[] rowcol = lowestNeighborOf(map, r, c);

		if (rowcol[0] == r && rowcol[1] == c) {
			// we reached the lowest neighbor (sink)
			String key = r + "," + c;
			int currentCount = sink2count.get(key);
			sink2count.put(key, (currentCount + 1));
		} else {
			// go to lowest neighbor
			basins(map, sink2count, rowcol[0], rowcol[1]);
		}

		return null;
	}

	private static String solve(int[][] map) {
		Map<String, Integer> sink2count = buildSinkMap(map);
		int n = map.length;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				basins(map, sink2count, r, c);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String key : sink2count.keySet()) {
			sb.append(sink2count.get(key) + " ");
		}

		return sb.toString().trim();
	}

	public static void main(String[] args) {

		//int[][] map = { { 1, 0, 2, 5, 8 }, { 2, 3, 4, 7, 9 }, { 3, 5, 7, 8, 9 }, { 1, 2, 5, 4, 2 }, { 3, 3, 5, 2, 1 } };
		//11 7 7

		int[][] map = { { 1, 5, 2 }, { 2, 4, 7 }, { 3, 6, 9 } };
		//7 2

		System.out.println(solve(map));
	}

}
