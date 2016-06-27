package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a list of integers, your task is to select K integers from the list such
 * that its unfairness is minimized.
 * 
 * if (x_1, x_2,...x_k) are K numbers selected from the list N, the unfairness is defined as:
 * 
 * max(x_1, x_2,...x_k) - min(x_1, x_2,...x_k)
 * 
 * where max denotes the largest integer among the elements of K, and min denotes
 * the smallest integer among the elements of K.
 * 
 * Input Format The first line contains an integer N. The second line contains an
 * integer K. N lines follow. Each line contains an integer that belongs to the
 * list N.
 * 
 * Note: Integers in the list N may not be unique.
 * 
 * Output Format An integer that denotes the minimum possible value of
 * unfairness.
 * 
 * 
 * Sample Input #00
 * 
 * 7
 * 
 * 3
 * 
 * 10
 * 
 * 100
 * 
 * 300
 * 
 * 200
 * 
 * 1000
 * 
 * 20
 * 
 * 30
 * 
 * 
 * 
 * Sample Output #00
 * 
 * 20
 * 
 * Explanation #00
 * 
 * Here ; selecting the integers such that = , unfairness equals
 * 
 * max(10,20,30) - min(10,20,30) = 30 - 10 = 20 Sample Input #01
 * 
 * 10
 * 
 * 4
 * 
 * 1
 * 
 * 2
 * 
 * 3
 * 
 * 4
 * 
 * 10
 * 
 * 20
 * 
 * 30
 * 
 * 40
 * 
 * 100
 * 
 * 200
 * 
 * 
 * Sample Output #01
 * 
 * 3
 * 
 * 
 * 
 * Explanation #01
 * 
 * Here ; selecting the integers , unfairness equals
 * 
 * max(1,2,3,4) - min(1,2,3,4) = 4 - 1 = 3
 * 
 * 
 * Sample Input #02
 * 
 * 6
 * 
 * 3
 * 
 * 10
 * 
 * 20
 * 
 * 30
 * 
 * 100
 * 
 * 101
 * 
 * 102
 * 
 * 
 * 
 * Sample Output #02
 * 
 * 2
 * 
 * 
 * Explanation #02
 * 
 * Here ; the integers so that the difference between the maximum and the
 * minimum is the smallest are , which means unfairness equals
 * 
 * max(100, 101, 102) - min(100, 101, 102) = 102 - 100 = 2
 * 
 * @author lucas
 *
 */
public class MaxMin {
	
	private static void print(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	private static void solve(int[] a, int n, int k) {
		Arrays.sort(a);
		int ans = Integer.MAX_VALUE;
		for (int i=0; i<=n-k; i++) {
			int min = a[i];
			int max = a[i+k-1];
			ans = Math.min(ans, max-min);
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = scanner.nextInt();
		}
		
		solve(a, n, k);
	}
}
