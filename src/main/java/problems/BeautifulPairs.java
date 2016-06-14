package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You are given two arrays, A and B, both containing integers.
 * 
 * A pair of indices (i,j) is beautiful if the ith element of array A is equal
 * to the jth element of array B. In other words, pair (i,j) is beautiful if and
 * only if A_i == B_j.
 * 
 * Given A and B, there are pairs of beautiful indices (i_0, j_0)...(i_(k-1),
 * j_(k-1)). A pair of indices in this set is pairwise disjoint if and only if
 * for each 0<=x<y<=k-1 it holds that i_x != i_y and j_x != j_y.
 * 
 * Change exactly 1 element in B so that the resulting number of pairwise
 * disjoint beautiful pairs is maximal, and print this maximal number to stdout.
 * 
 * Input Format
 * 
 * The first line contains a single integer, (the number of elements in A and
 * B).
 * 
 * The second line contains N space-separated integers describing array A.
 * 
 * The third line contains N space-separated integers describing array B.
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Determine and print the maximum possible number of pairwise disjoint
 * beautiful pairs.
 * 
 * Note: You must first change 1 element in B, and your choice of element must
 * be optimal.
 * 
 * @author lucas
 *
 */
public class BeautifulPairs {
	private static final int MAX = 1000;


		private static void solve(int[] a, int[] b) {
			int n = a.length;
			int[] countA = new int[MAX + 1];
	
			for (int i = 0; i < n; i++) {
				countA[a[i]] = countA[a[i]] + 1;
			}
	
			for (int i = 0; i < n; i++) {
				countA[b[i]] = Math.max(countA[b[i]] - 1, 0);
			}
			
			int mismatch = 0;
			for (int i = 0; i < countA.length; i++) {
				mismatch += countA[i];
			}
			
			int maxPossiblePairs = n - mismatch;
			
			if (maxPossiblePairs == n) {
				// when maxPossiblePairs == n (the maximum possible), changing one element in B will decrease our number of disjoint pairs necessarily
				maxPossiblePairs -= 1;
			} else {
				// when maxPossiblePairs is < n, then changing one in B we can create a new disjoint pair
				maxPossiblePairs += 1;
			}
	
			System.out.println(maxPossiblePairs);
	
		}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = scanner.nextInt();
		}

		solve(a, b);
	}
}
