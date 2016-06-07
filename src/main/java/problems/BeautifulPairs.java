package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
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

	private static class NumberCount implements Comparable<NumberCount> {
		int num;
		int count;

		public int compareTo(NumberCount anotherObject) {
			if (!(anotherObject instanceof NumberCount))
				throw new ClassCastException("A NumberCount object expected.");
			int anotherCount = ((NumberCount) anotherObject).count;
			return this.count - anotherCount;
		}
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static void solve(int[] a, int[] b) {
		int n = a.length;
		NumberCount[] countA = new NumberCount[MAX + 1];
		NumberCount[] countB = new NumberCount[MAX + 1];

		for (int i = 0; i <= MAX; i++) {
			countA[i] = new NumberCount();
			countB[i] = new NumberCount();
		}

		for (int i = 0; i < n; i++) {
			countA[a[i]].num = a[i];
			countA[a[i]].count++;

			countB[b[i]].num = a[i];
			countB[b[i]].count++;
		}

		Arrays.sort(countA);

		int count = 0;
		for (int i = 0; i <= MAX; i++) {
			count += (countA[i].count * countB[i].count);
		}
		System.out.println(count);

	}

	//	private static void solve(int[] a, int[] b) {
	//		int n = a.length;
	//		int[] countA = new int[MAX + 1];
	//		int[] countB = new int[MAX + 1];
	//
	//		for (int i = 0; i < n; i++) {
	//			countA[a[i]] = countA[a[i]] + 1;
	//			countB[b[i]] = countB[b[i]] + 1;
	//		}
	//
	//		print(countA);
	//		print(countB);
	//
	//		int count = 0;
	//		for (int i = 0; i <= MAX; i++) {
	//			count += (countA[i] * countB[i]);
	//		}
	//
	//		System.out.println(count);
	//
	//	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);
		Scanner output = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

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
