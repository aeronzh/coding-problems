package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * Given permutation A of N numbers whose unique elements range from 1 to N
 * (i.e.: A = {a_1, a_2, ... a_(n-1), a_n}). He wants A to be sorted so he
 * delegates the task of doing so to his robot. The robot can perform the
 * following operation as many times as it wants:
 * 
 * 1. Choose any 3 consecutive indices and rotate their elements in such a way
 * that ABC rotates to BCA, which rotates to CAB, which rotates back to ABC.
 * Example: 652 -> 265 -> 526 -> 652
 * 
 * For example: if A={1,6,5,2,4,3} and the robot rotates (6,5,2), A becomes
 * {1,5,2,6,4,3}.
 * 
 * 
 * On a new line for each test case, print YES if the robot can fully sort A;
 * otherwise, print NO.
 * 
 * @author lucas
 *
 */
public class LarrysArray {

	private static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/*********************** BRUTE FORCE *************************/
	private static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return false;
			}
		}

		return true;
	}

	private static void rotate(int[] a, int start, int end) {
		int last = a[end];
		for (int i = end; i > start; i--) {
			a[i] = a[i - 1];
		}
		a[start] = last;
	}

	private static String solve(int[] a, int n, int s) {
		if (isSorted(a)) {
			return "YES";
		} else {
			for (int i = s; i < n - 2; i++) {
				int start = i;
				int end = i + 2;

				// ABC -> CAB
				rotate(a, start, end);
				String ans = solve(a, n, start + 1);
				if ("YES".equals(ans)) {
					return ans;
				}

				// CAB -> BCA
				rotate(a, start, end);
				ans = solve(a, n, start + 1);
				if ("YES".equals(ans)) {
					return ans;
				}

				// BCA -> ABC
				rotate(a, start, end);
				ans = solve(a, n, start + 1);
				if ("YES".equals(ans)) {
					return ans;
				}
			}

			return "NO";
		}
	}

	/***************************************************************************************/
	// https://www.youtube.com/watch?v=TKXiHdgOHaU
	// https://en.wikipedia.org/wiki/Parity_of_a_permutation
	// https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
	// The array can be sorted only if the initial number of inversions is even (this is because you want 0 inversions at the end, which is even).
	private static void solve(int[] a, int n) {

		// 1,6,5,2,4,3
		// 0 4 3 0 1 0
		
		// 6 5 2 
		// 2 6 5
		int count = 0;
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if (a[j]<a[i]) {
					count++;
				}
			}
		}
		
		boolean ans = (count % 2 == 0);
		System.out.println(ans ? "YES" : "NO");
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}

			solve(a, n);
		}

	}
}
