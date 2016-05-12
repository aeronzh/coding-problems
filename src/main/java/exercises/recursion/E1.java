package exercises.recursion;

/**
 * 
 * Write a method to generate the nth Fibonacci number.
 * 
 * @author lucas
 *
 */
public class E1 {

	/**
	 * Generates the nth Fibonacci number (using a while loop).
	 * 
	 * @param n
	 * @return
	 */
	public static int fibWhile(int n) {
		int result = 1;
		int f1 = 0;
		int f2 = 1;
		int count = 1;
		while (count < n) {
			result = f1 + f2;
			f1 = f2;
			f2 = result;
			count++;
		}

		return result;
	}

	private static int fiRec(int n, int result, int f1, int f2) {
		if (n == 1) {
			return result;
		} else {
			result = f1 + f2;
			return fiRec(--n, result, f2, result);
		}
	}

	/**
	 * Generates the nth Fibonacci number (using recursion).
	 * 
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n) {
		return fiRec(n, 1, 0, 1);
	}

}
