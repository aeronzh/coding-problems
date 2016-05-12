package stacksqueues;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of
 * different sizes which can slide onto any tower. The puzzle starts with disks
 * sorted in ascending order of size from top to bottom (e g , each disk sits on
 * top of an even larger one).
 * 
 * You have the following constraints:
 * 
 * (A) Only one disk can be moved at a time
 * 
 * (B) A disk is slid off the top of one rod onto the next rod
 * 
 * (C) A disk can only be placed on top of a larger disk
 * 
 * 
 * Write a program to move the disks from the first rod to the last using Stacks
 * 
 * @author lucas
 *
 */
public class E4 {

	public static void solveHanoi(int n, String source, String intermediate, String destination) {
		if (n > 0) {
			// Move n-1 discs from source(A) to intermediate(B) using destination(C) as intermediate
			solveHanoi(n - 1, source, destination, intermediate);

			// Move 1 disc from source(A) to destination(C)
			System.out.println("Moving disc from " + source + " to " + destination);

			// Move the n-1 discs from intermediate(B) to destination(C) using source(A) as intermediate
			solveHanoi(n - 1, intermediate, source, destination);
		}
	}

	public static void main(String[] args) {
		solveHanoi(3, "A", "B", "C");

	}

}
