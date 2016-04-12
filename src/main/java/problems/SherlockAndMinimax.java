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
	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}
	
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

	private static int solve2(int[] a, int p, int q) {
		int start = 0;
		int end = a.length - 1;

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

	// Consider the following array:
	// 4 8 8 8 8 8 8 10 21
	// and the range 8-20
	//
	// 1. we iterate over it in pairs (4,8), (8,8) ... (10,21)
	// 2. for each pair we consider the middle value. Example (4+8)/2 = 6. So in that case 6 is the maximum distance to 4 as well as 8: 4---(6)---8 which is 2.
	// If we would choose 5, then |4-5|=1 which is smaller than 2. Remember we want the maximum. So 5 is not the value we want. Same goes if we would have chosen 7 as |8-7|=1 which is smaller than 2.
	// 3. Now that we have the number '6' for our pair (4,8) we check if 6 is in our range. That is, is '6' a potential M?
	// Since 6 is not in 8-21 we cannot consider it.
	//
	// So we repeat the process for the rest of the pairs (8,8)...(10,21).
	// For (8,8) we have middle  = (8+8)/2 = 8 which is in the range 8-21 and produces max min distance 0.
	// For (8,10) we have middle  = (8+10)/2 = 9 which is in the range 8-21 and produces max min distance 1.
	// For (10,21) we have middle  = (10+21)/2 = 15 which is in the range 8-21 and produces max min distance 5.
	// Since 15 produces the largest minimum (5) we choose 15 as our M.
	private static int solve(int[] a, int p, int q) {
		print(a);
		
		int minM = p;
		int n = a.length;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<n-1; i++) {
			int mid = (a[i]+a[i+1])/2;
			if (mid>=p && mid<=q) {
				int tmp = Math.min(Math.abs(a[i]-mid), Math.abs(a[i+1]-mid));
				if (tmp>max) {
					max = tmp;
					minM = mid;
				}
			}
		}
		
		
		// Left end
		int tmpMin = Integer.MAX_VALUE;
		for (int i=0; i<n; i++) {
			int tmp =  Math.abs(a[i]-p);
			if (tmp<tmpMin) {
				tmpMin = tmp;
			}
		}

		if (tmpMin>=max) {
			max = tmpMin;
			minM = p;
		}
		
		
		// Right end
		tmpMin = Integer.MAX_VALUE;
		for (int i=0; i<n; i++) {
			int tmp =  Math.abs(a[i]-q);
			if (tmp<tmpMin) {
				tmpMin = tmp;
			}
		}

		if (tmpMin>max) {
			max = tmpMin;
			minM = q;
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

		int result = solve(a, p, q);
		
		System.out.println(result);

	}
}
