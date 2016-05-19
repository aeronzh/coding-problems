package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

/**
 * You are given a tree where each node is labeled from to . How many similar
 * pairs(S) are there in this tree?
 * 
 * A pair (A,B) is a similar pair if the following are true:
 * 
 * - node A is the ancestor of node B
 * 
 * - abs(A-B) <= T
 * 
 * Input format: The first line of the input contains two integers, n and T.
 * This is followed by n-1 lines, each containing two integers s_i and e_i where
 * node s_i is a parent to node e_i.
 * 
 * Output format:
 * 
 * Output a single integer which denotes the number of similar pairs in the
 * tree.
 * 
 * Sample Input:
 * 
 * 5 2
 * 
 * 3 2
 * 
 * 3 1
 * 
 * 1 4
 * 
 * 1 5
 * 
 * 
 * Sample Output:
 * 
 * 4
 * 
 * Explanation:
 * 
 * The similar pairs are: (3, 2) (3, 1) (3, 4) (3, 5).
 * 
 * 
 * @author lucas
 *
 */
public class SimilarPair {
	static class FasterScanner {
		private InputStream mIs;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FasterScanner() {
			this(System.in);
		}

		public FasterScanner(InputStream is) {
			mIs = is;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = mIs.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}

	private static int solve(int[][] a, int t) {
		int n = a.length;

		return 0;
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		FasterScanner scanner = new FasterScanner(System.in);

		int n = scanner.nextInt();
		int t = scanner.nextInt();
		int[][] a = new int[n][2];
		for (int i = 0; i < n; i++) {
			a[i][0] = scanner.nextInt();
			a[i][1] = scanner.nextInt();
		}

		int result = solve(a, t);
		System.out.println(result);

	}

}
