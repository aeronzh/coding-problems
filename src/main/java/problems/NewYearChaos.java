package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster
 * ride!
 * 
 * There are n people queued up, and each person wears a sticker indicating
 * their initial position in the queue (i.e.: 1,2,3,...n-1,n with the first
 * number denoting the frontmost position).
 * 
 * Any person in the queue can bribe the person directly in front of them to
 * swap positions. If two people swap positions, they still wear the same
 * sticker denoting their original place in line. One person can bribe at most
 * two other persons.
 * 
 * That is to say, if n=8 and Person 5 bribes Person 4, the queue will look like
 * this: 1, 2, 3, 5, 4, 6, 7, 8.
 * 
 * Fascinated by this chaotic queue, you decide you must know the minimum number
 * of bribes that took place to get the queue into its current state!
 * 
 * Note: Each Person X wears sticker X, meaning they were initially the Xth
 * person in queue.
 * 
 * Input Format
 * 
 * The first line contains an integer, T, denoting the number of test cases.
 * Each test case is comprised of two lines; the first line has n (an integer
 * indicating the number of people in the queue), and the second line has n
 * space-separated integers describing the final state of the queue.
 * 
 * 
 * Output Format
 * 
 * Print an integer denoting the minimum number of bribes needed to get the
 * queue into its final state; print 'Too chaotic' if the state is invalid
 * (requires Person X to bribe more than 2 people).
 * 
 * @author lucas
 *
 */
public class NewYearChaos {

	// 1 2 5 3 7 8 6 4
	//
	// 1 2 3 4 5 6 7 8
	// 1 2 3 5 4 6 7 8
	// 1 2 5 3 4 6 7 8
	// 1 2 5 3 4 7 6 8
	// 1 2 5 3 7 4 6 8
	// 1 2 5 3 7 4 8 6
	// 1 2 5 3 7 8 4 6
	// 1 2 5 3 7 8 6 4

	// 5: 2             -> 3: 1 to left, 4: 1 to left
	// 3: 1 to the left
	// 7: 2             -> 6: 1 to left, 5: 1 to left
	// 8: 2             -> 
	// 6: 1 to the left
	// 4: 4 to the left
	private static void solve(int[] q, int n) {
		for (int i = 0; i < n; i++) {
			if (q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
		}

		// Bubble sort
		int count = 0;
		boolean swapped = true;
		while (swapped) {
			swapped = false;

			for (int i = 0; i < n - 1; i++) {
				if (q[i] > q[i + 1]) {
					// swap
					q[i] = q[i + 1] + q[i];
					q[i + 1] = q[i] - q[i + 1];
					q[i] = q[i] - q[i + 1];

					swapped = true;
					count++;
				}
			}

		}

		System.out.println(count);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();

		for (int t = 0; t < tests; t++) {
			int n = in.nextInt();
			int[] q = new int[n];
			for (int i = 0; i < n; i++) {
				q[i] = in.nextInt();
			}

			solve(q, n);
		}
	}

}
