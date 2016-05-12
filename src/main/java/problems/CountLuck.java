package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hermione Granger is lost in the Forbidden Forest while collecting some herbs for a magical potion. The forest is magical and has only one exit point, which magically transports her back to the Hogwarts School of Witchcraft and Wizardry.
 * The forest can be considered as a grid of N×M size. Each cell in the forest is either empty (represented by '.') or has a tree (represented by 'X'). Hermione can move through empty cells, but not through cells with a tree in it.
 * She can only travel LEFT, RIGHT, UP, and DOWN. Her position in the forest is indicated by the marker 'M' and the location of the exit point is indicated by '*'. Top-left corner is indexed (0, 0).
 * <p/>
 * .X.X......X
 * .X*.X.XXX.X
 * .XX.X.XM...
 * ......XXXX.
 * <p/>
 * In the above forest, Hermione is located at index (2, 7) and the exit is at (1, 2). Each cell is indexed according to Matrix Convention
 * <p/>
 * She starts her commute back to the exit, and every time she encounters more than one option to move, she waves her wand and the correct path is illuminated and she proceeds in that way. It is guaranteed that there is only one path to each reachable cell from the starting cell. Can you tell us if she waved her wand exactly K times or not? Ron will be impressed if she is able to do so.
 * <p/>
 * Input Format
 * The first line contains an integer T; T test cases follow.
 * Each test case starts with two space-separated integers, N and M. The next N lines contain a string, each having a length of M
 * , which represents the forest. The last line of each single test case contains integer K.
 * <p/>
 * Output Format
 * For each test case, if she could impress Ron then print Impressed, otherwise print Oops!.
 */
public class CountLuck {

    static final char TREE = 'X';
    public static final String IMPRESSED = "Impressed";
    public static final String OOPS = "Oops!";

    private static String solve(char[][] a, int k, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        if (a[r][c] == '*' && k==0) {
            return IMPRESSED;
        } else if (a[r][c] == '*' && k!=0) {
            return OOPS;
        } else {
            int n = a.length;
            int m = a[0].length;

            int options = 0;
            int[] tmp = {-1, 0, 1};
            int count = 0;
            for (int rowOff:tmp) {
                for (int colOff:tmp) {
                    int newRow = r+rowOff;
                    int newCol = c+colOff;
                    if (newRow>=0 && newRow<n
                            && newCol>=0 && newCol<m
                            && (Math.abs(rowOff) != Math.abs(colOff))
                            && a[newRow][newCol] != TREE
                            && !visited[newRow][newCol]) {
                        count++;
                    }
                }
            }

            options = (count>=2) ? 1 : 0;

            // up
            if (r>0 && a[r-1][c] != TREE && !visited[r-1][c]) {
                if (solve(a,k-options,r-1,c,visited).equals(IMPRESSED)) {
                    return IMPRESSED;
                }

            }

            // down
            if (r<n-1 && a[r+1][c] != TREE && !visited[r+1][c]) {
                if (solve(a,k-options,r+1,c,visited).equals(IMPRESSED)) {
                    return IMPRESSED;
                }
            }

            // left
            if (c>0 && a[r][c-1] != TREE && !visited[r][c-1]) {
                if (solve(a,k-options,r,c-1,visited).equals(IMPRESSED)) {
                    return IMPRESSED;
                }
            }

            // right
            if (c<m-1 && a[r][c+1] != TREE && !visited[r][c+1]) {
                if (solve(a,k-options,r,c+1,visited).equals(IMPRESSED)) {
                    return IMPRESSED;
                }
            }

            return OOPS;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] a = new char[n][m];
            int startRow = 0; int startCol = 0;
            for (int i = 0; i < n; i++) {
                String line = scanner.next();
                if (line.contains("M")) {
                    startCol = line.indexOf("M");
                    startRow = i;
                }
                a[i] = line.toCharArray();
            }

            int k = scanner.nextInt();

            boolean[][] visited = new boolean[n][m];

            System.out.println(solve(a,k,startRow, startCol, visited));
        }
    }
}
