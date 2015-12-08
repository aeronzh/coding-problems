package problems;

/**
 * Count the number of prime numbers less than a non-negative number, n
 * 
 * @author lucas
 *
 */
public class CountPrimes {

	private static void print(boolean[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	// Sieve of Eratosthenes
	public static int solve(int n) {
		int p = 2;

		// init an array to track prime numbers
		boolean[] array = new boolean[n + 1];

		for (int i = 0; i < array.length; i++) {
			array[i] = true;
		}

		while (p < Math.sqrt(n)) {

			for (int i = p; i <= n / p; i++) {
				array[i * p] = false;
			}

			// get next prime
			p = p + 1;
			while (p <= n && array[p] == false) {
				p++;
			}

		}

		int count = 0;
		for (int i = 2; i < array.length; i++) {
			if (array[i]) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(solve(7));

	}

}
