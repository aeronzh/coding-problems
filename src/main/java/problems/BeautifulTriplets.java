package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Erica wrote an increasing sequence of numbers (a_0, a_1, ... , a_(n-1)) in
 * her notebook. She considers a triplet (ai, aj, ak) to be beautiful if:
 * 
 * i < j < k
 * 
 * a[j] -a[i] = a[k] - a[j] = d
 * 
 * Given the sequence and the value of d, can you help Erica count the number of
 * beautiful triplets in the sequence?
 * 
 * @author lucas
 *
 */
public class BeautifulTriplets {

	private static void solve(int[] a, int n, int d) { 
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i=0; i<n; i++) {
			set.add(a[i]);
		}
		
		
		int count = 0;
		for (int i=0; i<n; i++) {
			if (set.contains(a[i]+d) && set.contains(a[i]+(2*d))) {
				count++;
			}
		}
		// 147 258 4710  
		System.out.println(count);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		// 1 2 4 5 7 8 10
		int n = in.nextInt();
		int d = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		solve(a, n, d);
	}
}
