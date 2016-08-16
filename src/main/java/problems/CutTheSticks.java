package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * You are given N sticks, where the length of each stick is a positive integer. A
 * cut operation is performed on the sticks such that all of them are reduced by
 * the length of the smallest stick.
 * 
 * Suppose we have six sticks of the following lengths:
 * 
 * 5 4 4 2 2 8 
 * 
 * Then, in one cut operation we make a cut of length 2 from each of
 * the six sticks. For the next cut operation four sticks are left (of non-zero
 * length), whose lengths are the following:
 * 
 * 3 2 2 6 
 * 
 * The above step is repeated until no sticks are left.
 * 
 * Given the length of N sticks, print the number of sticks that are left before
 * each subsequent cut operations.
 * 
 * Note: For each cut operation, you have to recalcuate the length of smallest
 * sticks (excluding zero-length sticks).
 * 
 * @author lucas
 *
 */
public class CutTheSticks {

	private static void solve(PriorityQueue<Integer> minHeap, int n) {
		PriorityQueue<Integer> newHeap = new PriorityQueue<Integer>();
		do {
			System.out.println(minHeap.size());
			int min = minHeap.peek();
			while (!minHeap.isEmpty()) {
				int tmp = minHeap.poll();
				if (tmp != min) {
					newHeap.add(tmp - min);
				}
			}

			minHeap.addAll(newHeap);
			newHeap.clear();
		} while (!minHeap.isEmpty());
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i < n; i++) {
			minHeap.add(in.nextInt());
		}

		solve(minHeap, n);
	}
}
