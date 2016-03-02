package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubstringDiff {

	static int[][][] dp;
	/**
	 * Given two strings of length n, P = p1p2...pn and Q = q1q2...qn, we define
	 * M(i,j,k) as the number of mismatches between p(i),p(i+1),...p(i+k−1) and
	 * q(j),q(j+1)...,q(j+k−1)
	 * 
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	private static int m(int i, int j, int k, String strP, String strQ) {
		char[] p = strP.toCharArray();
		char[] q = strQ.toCharArray();

		int count = 0;
		for (int c = 0; c < k; c++) {
			if (p[i + k] != q[j + k]) {
				count++;
			}
		}

		return count;
	}

	/**
	 * Given an integer S, your task is to find the maximum length L, such that
	 * there exists a pair of indices (i,j) for which we have M(i,j,L) ≤ S. Of
	 * course, we should also have i+L−1 ≤ ni+L−1 ≤ n and j+L−1 ≤ nj+L−1 ≤ n.
	 * 
	 * @return
	 */
	private static int brute(int s, String p, String q) {
		int n = p.length();
		int max = 0;

		for (int l = n; l >=0 ; l--) {
			for (int i = 0; i < n-l; i++) {
				for (int j = 0; j < n-l; j++) {
					//System.out.println("i="+i+"  j="+j+"  l="+l);
					int tmp = m(i, j, l, p, q);
					if (tmp<=s) {						
						max = Math.max(max, l);
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:/Temp/in.txt")); // 4 3 8

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();

		for (int t = 1; t <= tests; t++) {
			int s = scanner.nextInt();
			String[] line = scanner.nextLine().trim().split(" ");
			String p = line[0];
			String q = line[1];
			int n = p.length();
//			dp = new int[n][n][n+1];
//			
//			for (int i=0; i<n; i++) {
//				for (int j=0; j<n; j++) {
//					for (int c=0; c<=n; c++) {
//						dp[i][j][c] = -1;
//					}
//				}
//			}
			System.out.println(brute(s, p, q));
		}
	}

}
