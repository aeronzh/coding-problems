package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lucas
 *
 */
public class Shapes {

	/**
	 * Rotates an NxM matrix clockwise by 90 degrees.
	 * 
	 * @param source
	 */
	private static int[][] rotate(int[][] source) {
		int rows = source.length;
		int cols = source[0].length;
		int[][] target = new int[cols][rows];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				target[c][rows - r - 1] = source[r][c];
			}
		}

		return target;
	}

	/**
	 * Clones the provided array
	 * 
	 * @param src
	 * @return a new clone of the provided array
	 */
	public static int[][] cloneMatrix(int[][] src) {
		int length = src.length;
		int[][] target = new int[length][src[0].length];
		for (int i = 0; i < length; i++) {
			System.arraycopy(src[i], 0, target[i], 0, src[i].length);
		}
		return target;
	}

	/**
	 * Prints a matrix to the screen.
	 * 
	 * @param matrix
	 */
	public static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
		for (int r = 0; r < rows; r++) {
			int cols = matrix[r].length;
			for (int c = 0; c < cols; c++) {
				if (matrix[r][c] == 0) {
					System.out.print(" ");
				} else {
					System.out.print(matrix[r][c] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Prints the shapes to the screen.
	 * 
	 * @param shapes
	 */
	private static void printShapes(List<int[][]> shapes) {
		for (int i = 0; i < shapes.size(); i++) {
			int[][] shape = shapes.get(i);
			System.out.println("Shape " + (i + 1) + ":");
			printMatrix(shape);
		}
	}

	/**
	 * Returns true if we can place the shape into the area at the given row and
	 * col. Else it returns false.
	 * 
	 */
	private static boolean canPlace(int[][] area, int[][] shape, int r, int c) {
		int rows = shape.length;
		int cols = shape[0].length;

		if (r + rows >= area.length || c + cols >= area[0].length) {
			return false;
		} else {
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					if (area[r + row][c + col] != 0 && shape[row][col] != 0) {
						return false;
					}
				}
			}

			return true;
		}
	}

	/**
	 * Place shape in area at given row and col
	 * 
	 * @param area
	 * @param shape
	 * @param r
	 * @param c
	 */
	private static void place(int[][] area, int[][] shape, int r, int c) {
		int rows = shape.length;
		int cols = shape[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (shape[row][col] != 0) {
					area[r + row][c + col] = shape[row][col];
				}
			}
		}
	}

	/**
	 * Returns maximum area required to cover the current shapes placed in the
	 * area.
	 * 
	 * @param area
	 * @return
	 */
	private static int coveringArea(int[][] area) {
		int rows = area.length;
		int cols = area[0].length;

		int startRow = rows - 1;
		int endRow = 0;

		int startCol = cols - 1;
		int endCol = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (area[row][col] != 0) {
					if (row <= startRow) {
						startRow = row;
					}

					if (row >= endRow) {
						endRow = row;
					}

					if (col <= startCol) {
						startCol = col;
					}

					if (col >= endCol) {
						endCol = col;
					}
				}
			}
		}

		int width = endCol - startCol + 1;
		int height = endRow - startRow + 1;

		return width * height;
	}

	private static int[][] distribute_old(List<int[][]> shapes, int[][] area, int[][] resultArea) {
		if (shapes.size() == 0) {
			if (coveringArea(area) < coveringArea(resultArea)) {
				return area;
			} else {
				return resultArea;
			}
		} else {
			int rows = area.length;
			int cols = area[0].length;

			int[][] result = resultArea;

			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					for (int i = 0; i < shapes.size(); i++) {
						int[][] shape = shapes.get(i);

						// 0, 90, 180, and 270 degrees
						for (int x = 1; x <= 4; x++) {
							shape = rotate(shape);

							boolean canPlace = canPlace(area, shape, row, col);
							if (canPlace) {
								int[][] tmpArea = cloneMatrix(area);
								place(tmpArea, shape, row, col);

								List<int[][]> tmpShapes = new ArrayList<int[][]>(shapes);
								tmpShapes.remove(i);

								result = distribute(tmpShapes, tmpArea, result);
							}
						}
					}
				}
			}
			return result;
		}
	}

	private static int[][] distribute(List<int[][]> shapes, int[][] area, int[][] resultArea) {
		if (shapes.size() == 0) {
			if (coveringArea(area) < coveringArea(resultArea)) {
				return area;
			} else {
				return resultArea;
			}
		} else {
			int rows = area.length;
			int cols = area[0].length;

			int[][] result = resultArea;

			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					for (int i = 0; i < shapes.size(); i++) {
						int[][] shape = shapes.get(i);

						// 0, 90, 180, and 270 degrees
						for (int x = 1; x <= 4; x++) {
							shape = rotate(shape);

							boolean canPlace = canPlace(area, shape, row, col);
							if (canPlace) {
								int[][] tmpArea = cloneMatrix(area);
								place(tmpArea, shape, row, col);

								List<int[][]> tmpShapes = new ArrayList<int[][]>(shapes);
								tmpShapes.remove(i);

								result = distribute(tmpShapes, tmpArea, result);
							}
						}
					}
				}
			}
			return result;
		}
	}

	/**
	 * Returns an area matrix with the shapes placed in that area optimally.
	 * 
	 * @param shapes
	 * @param area
	 * @return
	 */
	public static int[][] solve(List<int[][]> shapes, int[][] area) {
		int[][] resultArea = new int[area.length][area[0].length];
		int rows = area.length;
		for (int r = 0; r < rows; r++) {
			int cols = area[r].length;
			for (int c = 0; c < cols; c++) {
				resultArea[r][c] = 1;
			}
		}
		return distribute(shapes, area, resultArea);
	}

	public static void main(String[] args) {
		int[][] area = new int[100][100];

		List<int[][]> shapes = new ArrayList<int[][]>();
		shapes.add(new int[][] { { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } });
		//shapes.add(new int[][] { { 2, 2 } });
		shapes.add(new int[][] { { 3, 3, 3 }, { 3, 0, 0 }, { 3, 0, 0 } });
		shapes.add(new int[][] { { 4 } });
		//		shapes.add(new int[][] { { 5 } });
		printShapes(shapes);

		int[][] result = solve(shapes, area);
		printMatrix(result);
	}

}
