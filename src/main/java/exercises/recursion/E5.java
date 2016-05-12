package exercises.recursion;

/**
 * Implement an algorithm to print all valid (e g , properly opened and closed)
 * combinations of n-pairs of parentheses.
 * 
 * EXAMPLE:
 * 
 * input: 3 (e g , 3 pairs of parentheses)
 * 
 * output: ()()(), ()(()), (())(), ((()))
 * 
 * @author lucas
 *
 */

public class E5 {

	private static void printPar(int n, int numOpen, int numClosed, String str) {
		if (numOpen < n || numClosed < n) {
			if (numClosed < numOpen) {
				// close one
				if (numClosed < n) {
					printPar(n, numOpen, numClosed + 1, str + ")");
				}

				// open one
				if (numOpen < n) {
					printPar(n, numOpen + 1, numClosed, str + "(");
				}
			} else {
				// open one
				if (numOpen < n) {
					printPar(n, numOpen + 1, numClosed, str + "(");
				}
			}
		} else {
			System.out.println(str);
		}
	}

	/**
	 * Prints all valid (e g , properly opened and closed) combinations of
	 * n-pairs of parentheses.
	 * 
	 * @param n
	 * @param numOpen
	 * @param numClosed
	 * @param str
	 */
	public static void printPar(int n) {
		printPar(4, 0, 0, "");
	}

	public static void main(String[] args) {
		printPar(4);
	}

}
