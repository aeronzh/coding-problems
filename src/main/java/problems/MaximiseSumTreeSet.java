package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * You are given an array of size N and another integer M. Your target is to
 * find the maximum value of sum of subarray modulo M.
 * 
 * Subarray is a continuous subset of array elements.
 * 
 * Note that we need to find the maximum value of (Sum of Subarray)%M , where
 * there are possible subarrays.
 * 
 * For a given array of size , subarray is a contiguous segment from to where
 * 
 * Input Format
 * 
 * First line contains T , number of test cases to follow. Each test case
 * consists of exactly 2 lines. First line of each test case contain 2 space
 * separated integers and , size of the array and modulo value M. Second line
 * contains N space separated integers representing the elements of the array.
 * 
 * Output Format
 * 
 * For every test case output the maximum value asked above in a newline.
 * 
 * 
 * Sample Input
 * 
 * 1
 * 
 * 5 7
 * 
 * 3 3 9 9 5
 * 
 * 
 * Sample Output
 * 
 * 6
 * 
 * 
 * @author lucas
 *
 */
public class MaximiseSumTreeSet {

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
	
    
    private static long solve(long[] a, long m) {
        int n = a.length;
        long[] s = new long[n];
        s[0] = a[0] % m;
        for (int i=1; i<n; i++) {
            s[i] = (s[i-1] + a[i]) % m;
        }

        TreeSet<Long> set = new TreeSet<Long>();
        long max = s[0];
        set.add(s[0]);
        for (int i=1; i<n; i++) {
            set.add(s[i]);
            
            // Returns the least element in this set strictly greater than the given element, or null if there is no such element.
            Long value = set.higher(s[i]);
            if (value == null) {
            	value = 0l;
            }
            long sum = (s[i] - value + m) % m;
            max = Math.max(max,Math.max(sum, s[i]));
        }


        return max;
    }
    
    private static void print(long[] a) {
    	for (int i=0; i<a.length; i++) {
    		System.out.print(a[i]+" ");
    	}
    	System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        FasterScanner scanner = new FasterScanner(System.in);
        
		Scanner output = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));
        
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int n = scanner.nextInt();
            long m = scanner.nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            long result = solve(a, m);
            long expected = output.nextLong();
            if (result != expected) {
            	System.out.println("Got "+result + " but expected "+expected);
            	print(a);
            	System.out.println();
            } else {            	
            	System.out.println(result);
            }
            
        }
    }

}
