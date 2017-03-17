package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * **Problem statement**
A $latex 10 \times 10$ Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid. 
The cells in the grid are initially, either `+` signs or `-` signs. 
Cells marked with a `+` have to be left as they are. Cells marked with a `-` need to be filled up with an appropriate character.

**Input Format**
The input contains $latex 10$ lines, each with $latex 10$ characters (which will be either `+` or `-` signs). 
After this follows a set of words (typically nouns and names of places), separated by semi-colons (`;`).

**Constraints**
There will be no more than ten words. Words will only be composed of upper-case `A-Z` characters. There will be no punctuation (hyphen, dot, etc.) in the words.

**Output Format**
Position the words appropriately in the $latex 10 \times 10$ grid, and then display the $latex 10 \times 10$ grid as the output. So, your output will consist of $latex 10$ lines with $latex 10$ characters each.

**Sample Input 0**
+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
LONDON;DELHI;ICELAND;ANKARA

**Sample Output 0**
+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++

**Sample Input 1**

+-++++++++
+-++++++++
+-------++
+-++++++++
+-++++++++
+------+++
+-+++-++++
+++++-++++
+++++-++++
++++++++++
AGRA;NORWAY;ENGLAND;GWALIOR

**Sample Output 1**
+E++++++++
+N++++++++
+GWALIOR++
+L++++++++
+A++++++++
+NORWAY+++
+D+++G++++
+++++R++++
+++++A++++
++++++++++

 * @author 
 *
 */
public class CrosswordPuzzle {

	private static void print(char[][] board) {
		for (int r = 0; r < 10; r++) {
			System.out.println(new String(board[r]));
		}
		//System.out.println();
	}

	private static boolean solve(char[][] board, List<String> words, List<Integer[]> h, List<Integer[]> v, Set<String> used) {

		if (used.size() == words.size()) {
			print(board);
			return true;
		}

		for (String w : words) {
			if (!used.contains(w)) {

				// HORIZONTAL

				for (Integer[] pos : h) {
					int row = pos[0];
					int col = pos[1];
					//System.out.print("Tesing position "+row+","+col+" for word "+w+"...");
					boolean fit = true;

					// Backup
					char[] backup = Arrays.copyOf(board[row], 10);

					// Place the word
					for (int i = col; i < col + w.length(); i++) {
						if (i >= 10 || board[row][i] == '+' || (board[row][i] != '-' && board[row][i] != w.charAt(i - col))) {
							fit = false;
							break;
						}
						board[row][i] = w.charAt(i - col);
					}

					//System.out.println("fit="+fit);

					// Recursive call
					if (fit) {
						used.add(w);
						boolean found = solve(board, words, h, v, used);

						if (found) {
							return true;
						}

						used.remove(w);
					}

					// Restore
					board[row] = Arrays.copyOf(backup, 10);
				}

				// VERTICAL

				for (Integer[] pos : v) {
					int row = pos[0];
					int col = pos[1];
					boolean fit = true;

					// Backup
					char[] backup = new char[10];
					for (int r = 0; r < 10; r++) {
						backup[r] = board[r][col];
					}

					// Place the word
					for (int i = row; i < row + w.length(); i++) {
						if (i >= 10 || board[i][col] == '+' || (board[i][col] != '-' && board[i][col] != w.charAt(i - row))) {
							fit = false;
							break;
						}
						board[i][col] = w.charAt(i - row);
					}

					//System.out.println("fit="+fit);

					// Recursive call
					if (fit) {
						used.add(w);
						boolean found = solve(board, words, h, v, used);

						if (found) {
							return true;
						}
						used.remove(w);
					}

					// Restore
					for (int r = 0; r < 10; r++) {
						board[r][col] = backup[r];
					}
				}

			}
		}

		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		char[][] board = new char[10][10];
		for (int r = 0; r < 10; r++) {
			board[r] = in.next().toCharArray();
		}

		String[] w = in.next().split(";");

		List<String> words = new ArrayList<String>();
		for (String word : w) {
			words.add(word);
		}

		List<Integer[]> h = new ArrayList<Integer[]>();
		List<Integer[]> v = new ArrayList<Integer[]>();
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (board[r][c] == '-') {
					// HORIZONTAL	
					// Go all the way to the left
					int start = c;
					while (start > 0 && board[r][start - 1] == '-') {
						start--;
					}
					h.add(new Integer[] { r, start });

					// VERTICAL	
					// Go all the way up
					start = r;
					while (start > 0 && board[start - 1][c] == '-') {
						start--;
					}
					v.add(new Integer[] { start, c });
				}
			}
		}

		solve(board, words, h, v, new HashSet<String>());
	}

}
