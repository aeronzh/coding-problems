package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class SimilarPairBIT {

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

	static class FenwickTree {
		int tree[];

		public FenwickTree(int arr[]) {
			tree = new int[arr.length + 1];
			tree[0] = 0;
			this.construct(1, arr);
		}

		private void construct(int index, int arr[]) {
			if (index - 1 < arr.length) {
				tree[index] = tree[index] + arr[index - 1];
				int next = index + (index & (-1 * index));
				this.construct(next, arr);
			}
		}

		public int sum(int start, int end) {
			int sum = 0;
			int treeStart = start + 1;
			int treeEnd = end + 1;

			if (treeStart <= treeEnd) {
				int next = treeStart + (treeStart & (-1 * treeStart));
				sum += tree[treeStart] + sum(next, end);
			}
			return sum;
		}

	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}

	// 5 2
	//
	// 3 2
	// 3 1
	// 1 4
	// 1 5

	// 3 3 1 1
	// 2 1 4 5
	// 2 1 _ 3 4 a[i] = Math.abs(parent-i). Example: 3 2 -> a[2] = Math.abs(3 - 2) = 1
	//
	private static int solve(int[] a, int t) {
		int n = a.length;

		int count = 0;

		return count;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		FasterScanner scanner = new FasterScanner(System.in);

		int n = scanner.nextInt();
		int t = scanner.nextInt();
		int[] a = new int[(n + 1)];
		for (int i = 0; i < n - 1; i++) {
			int parent = scanner.nextInt();
			int child = scanner.nextInt();
			a[(parent - 1) * parent + child] = 1;
		}

		print(a);

	}
}
