package problems;


/**
 * Created by lucas on 13/02/16.
 */
public class RotateMatrix2 {
        public static void main(String[] args) {
//            int a[][] = {
//                    {1,  2,  3,  4},
//                    {7,  8,  9, 10 },
//                    {13, 14, 15, 16},
//                    {19, 20, 21, 22},
//                    {25, 26, 27 ,28 }
//            };

            int a[][] = {
                    {1,  2, 3}
            };
            int rows = a.length;
            int columns = a[0].length;
            int rotations = 2;

            int layers = Math.min(rows, columns)/2;
            int maxPositions = ((rows-1) + (columns-1))*2;
            int neededRotations = rotations % maxPositions;
            for (int rot=1; rot<=neededRotations; rot++) {
                for (int l = 0; l < layers; l++) {
                    int r = l;
                    int c = columns - 1 - l;

                    // Top row
                    int newValue = a[r][c];
                    int oldValue = -666;
                    while (c > l) {
                        oldValue = a[r][c - 1];
                        a[r][c - 1] = newValue;
                        newValue = oldValue;
                        c--;
                    }

                    // Left column
                    while (r < rows - l - 1) {
                        oldValue = a[r + 1][c];
                        a[r + 1][c] = newValue;
                        newValue = oldValue;
                        r++;
                    }

                    // Bottom row
                    while (c < columns - l - 1) {
                        oldValue = a[r][c + 1];
                        a[r][c + 1] = newValue;
                        newValue = oldValue;
                        c++;
                    }

                    // Right column
                    while (r > l) {
                        oldValue = a[r - 1][c];
                        a[r - 1][c] = newValue;
                        newValue = oldValue;
                        r--;
                    }
                }

            }

            for(int a_i=0; a_i < rows; a_i++){
                for(int a_j=0; a_j < columns-1; a_j++){
                    System.out.print(a[a_i][a_j]+" ");
                }
                System.out.print(a[a_i][columns-1]);
                System.out.println();
            }
        }
}
