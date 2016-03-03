package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubstringDiff {

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
	private static int solve(int s, String strP, String strQ) {
		int n = strP.length();
		int result = 0;
		for (int i=0; i<n; i++) {
			result = Math.max(result,Math.max(brute(s,strP,strQ,0,i), brute(s,strP,strQ,i,0)));
		}
		
		return result;
	}

	/**
	 * Given an integer S, your task is to find the maximum length L, such that
	 * there exists a pair of indices (i,j) for which we have M(i,j,L) ≤ S. Of
	 * course, we should also have i+L−1 ≤ ni+L−1 ≤ n and j+L−1 ≤ nj+L−1 ≤ n.
	 * 
	 * @return
	 */
	private static int brute(int s, String strP, String strQ, int i, int j) {
		int n = strP.length();
		char[] p = strP.toCharArray();
		char[] q = strQ.toCharArray();
		int l = 0;

		int diff = 0;
		int max = 0;
		while (true) {
			//System.out.println("i="+i+"  j="+j+"  l="+l+"  diff="+diff);
			if (i + l >= n || j + l >= n) {
				max = Math.max(max, l);
				break;
			}

			if (p[i + l] != q[j + l]) {
				diff++;
			}

			if (diff > s) {
				max = Math.max(max, l);

				// shift i,j to the right until we find a p[i] != p[j] we can remove so we can decrease
				// diff by 1 and make it <= s again. By shifting the i,j positions to the right we simultaneously decrease our length k
				while (p[i] == q[j]) {
					i++;
					j++;
					l--;
				}

				// found a p[i] != p[j].
				diff--;
				i++;
				j++; // shift one to the right to remove it
			} else {
				l++;
			}
		}


		return max;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:/Temp/in.txt")); // 4
		// 3
		// 8

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();

		for (int t = 1; t <= tests; t++) {
			int s = scanner.nextInt();
			String[] line = scanner.nextLine().trim().split(" ");
			String p = line[0];
			String q = line[1];
			int n = p.length();
			System.out.println(solve(s, p, q));
		}
	}

}
