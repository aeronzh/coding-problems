package problems;

/**
 * Given numRows, generate the first numRows of Pascal's triangle. For example,
 * given numRows = 5, the result should be:
 * 
 * [
 * 
 * .....[1],
 * 
 * ....[1,1],
 * 
 * ...[1,2,1],
 * 
 * ..[1,3,3,1],
 * 
 * .[1,4,6,4,1]
 * 
 * ]
 * 
 * 
 * @author lucas
 *
 */
public class PascalTriangle {

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void solve(int n) {
		if (n >= 1) {
			int[] prevRow = { 1 };
			print(prevRow);
			for (int r = 2; r <= n; r++) {
				int[] row = new int[r];
				row[0] = 1;
				row[r - 1] = 1;
				for (int j = 1; j < r - 1; j++) {
					row[j] = prevRow[j - 1] + prevRow[j];
				}

				print(row);
				prevRow = row;
			}
		}
	}

	public static void main(String[] args) {
		solve(5);
	}

}
