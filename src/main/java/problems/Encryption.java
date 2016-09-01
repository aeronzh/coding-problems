package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * An English text needs to be encrypted using the following encryption scheme.
 * First, the spaces are removed from the text. Let L be the length of this
 * text. Then, characters are written into a grid, whose rows and columns have
 * the following constraints:
 * 
 * floor(sqrt(L)) <= rows <= columns <= ceil(sqrt(L))
 * 
 * For example, the sentence 'if man was meant to stay on the ground god would
 * have given us roots' after removing spaces is 54 characters long, so it is
 * written in the form of a grid with 7 rows and 8 columns.
 * 
 * ifmanwas
 * 
 * meanttos
 * 
 * tayonthe
 * 
 * groundgo
 * 
 * dwouldha
 * 
 * vegivenu
 * 
 * sroots
 * 
 * 
 * 1. Ensure that rows*columns <= L
 * 
 * 2. If multiple grids satisfy the above conditions, choose the one with the
 * minimum area, i.e. rows*columns.
 * 
 * The encoded message is obtained by displaying the characters in a column,
 * inserting a space, and then displaying the next column and inserting a space,
 * and so on. For example, the encoded message for the above rectangle is:
 * 
 * imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
 * 
 * You will be given a message in English with no spaces between the words. The
 * maximum message length can be 81 characters. Print the encoded message.
 * 
 * Here are some more examples:
 * 
 * Sample Input:
 * 
 * haveaniceday
 * 
 * 
 * Sample Output:
 * 
 * hae and via ecy
 * 
 * @author lucas
 *
 */
public class Encryption {

	private static void solve(String str) {
		int l = str.length();
		int lower = (int) Math.floor(Math.sqrt(l));
		int upper = (int) Math.ceil(Math.sqrt(l));

		// find width and height
		int minArea = Integer.MAX_VALUE;
		int rows = 0;
		int cols = 0;
		for (int c = lower; c <= upper; c++) {
			for (int r = lower; r <= c; r++) {
				if (r * c >= l) {
					if (r * c < minArea) {
						minArea = r * c;
						rows = r;
						cols = c;
					}
				}
			}
		}

		for (int c = 0; c < cols; c++) {
			for (int r = 0; r < rows; r++) {
				if ((c + r * cols) < l) {
					System.out.print(str.charAt(c + r * cols));
				}
			}
			System.out.print(" ");
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		while (in.hasNext()) {
			sb.append(in.next());
		}
		solve(sb.toString());
	}
}
