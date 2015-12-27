package exercises.recursion;

/**
 * Write an algorithm to print all ways of arranging eight queens on a chess
 * board so that none of them share the same row, column or diagonal.
 * 
 * @author lucas
 *
 */
public class E8 {

    private static void print(int[] columnForRow) {
        int n = columnForRow.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (columnForRow[r]==c) {
                    System.out.print("x ");
                } else {
                    System.out.print("o ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void solve(int row, int[] columnForRow) {
        if (row == 8) {
            // done. print matrix
            print(columnForRow);
        } else {
            
            for (int col = 0; col < 8; col++) {
                // Check diagonal
                boolean diagonal = false;
                for (int r=0; r<row; r++) {
                    if (Math.abs(columnForRow[r] - col) == Math.abs(row - r)) {
                        diagonal = true;
                    }
                }

                // Check column
                boolean column = false;
                for (int r=0; r<row; r++) {
                    if (columnForRow[r] == col) {
                        column = true;
                    }
                }

                if (!diagonal && !column) {
                    columnForRow[row] = col;
                    solve(row+1, columnForRow);
                }

            }

        }

    }

	public static void main(String[] args) {
        // columnForRow[i] holds the column number we placed the queen in row i. e.h columnForRow[2] = 5, means at row 2 the
        // queen is placed in column 5
        int[] columnForRow = new int[8];
        solve(0, columnForRow);
	}

}
