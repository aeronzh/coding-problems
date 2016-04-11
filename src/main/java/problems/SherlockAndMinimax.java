package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Watson gives Sherlock an array A1,A2...AN. He asks him to find an integer M
 * between P and Q(both inclusive), such that, min {|Ai-M|, 1 ≤ i ≤ N} is
 * maximised. If there are multiple solutions, print the smallest one.
 * 
 * Input Format The first line contains N. The next line contains space
 * separated N integers, and denote the array A. The third line contains two
 * space separated integers denoting P and Q.
 * 
 * Output Format In one line, print the required answer.
 * 
 * Constraints
 * 
 * 1 ≤ N ≤ 10^2
 * 
 * 1 ≤ Ai ≤ 10^9
 * 
 * 1 ≤ P ≤ Q ≤ 10^9
 * 
 * Sample Input
 * 
 * 3
 * 
 * 5 8 14
 * 
 * 4 9
 * 
 * Sample Output
 * 
 * 4
 * 
 * 
 * Explanation For M = 4,6,7, or 9, the result is 1. Since we have to output the
 * smallest of the multiple solutions, we print 4.
 * 
 * @author lucas
 *
 */
public class SherlockAndMinimax {
	// Returns the INDEX of the element in the sorted array a that is the nearest to num
	private static int search(int[] a, int start, int end, int num, int lastMid) {
		int mid = start + (end - start) / 2;

		if (start == end) {
			return start;
		}

		if (mid == lastMid) {
			if (Math.abs(num - a[start]) < Math.abs(num - a[end])) {
				return start;
			} else {
				return end;
			}
		}

		if (num == a[mid]) {
			return mid;
		} else if (num < a[mid]) {
			// go left
			return search(a, start, mid, num, mid);
		} else {
			// go right
			return search(a, mid, end, num, mid);
		}
	}

	// 4 8 8 8 8 8  8 10 21
	
	//  8 9 10 11 12 13 14 15 16 17 18 19 20 21
	//  0 1  0  1  2  3  4  5  5 4   3  2 1  0
	private static int solve(int[] a, int p, int q) {
		int start = 0;
		int end = a.length - 1;

		long startTime = System.nanoTime();
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] >= p) {
				start = Math.max(0, i - 1);
				break;
			}
		}

		for (int i = a.length - 1; i >= start; i--) {
			if (a[i] <= q) {
				end = Math.min(a.length - 1, i + 1);
				break;
			}
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000000; 
		System.out.println("Time: "+duration+ "s");
		
		int max = Integer.MIN_VALUE;
		int minM = p;
		int prev = -1;
		for (int m = p; m <= q; m++) {
			int min;
			if (prev == -1 || prev < m) {
				int index = search(a, start, end, m, -1);
				prev = a[index];
				start = index;
			}
			
			min = Math.abs(m - prev);
			if (min > max) {
				max = min;
				minM = m;
			}
		}

		return minM;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
		
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			minHeap.add(scanner.nextInt());
		}
		
		for (int i=0; i<n; i++) {
			a[i] = minHeap.poll();
		}

		int p = scanner.nextInt();
		int q = scanner.nextInt();

		long startTime = System.nanoTime();
		int result = solve(a, p, q);
		long endTime = System.nanoTime();
		
		System.out.println(result);

		long duration = (endTime - startTime)/1000000000; 
		System.out.println("Total: "+duration+ "s");
	}
}
