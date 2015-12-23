package problems;

/**
 * Write a program that takes an integer argument and returns all the primes
 * between 1 and that integer. For example, if the input is 18, you should
 * return [2,3,5,7,11,13,17].
 * 
 * @author lucas
 *
 */
public class EnumerateAllPrimesToN {

	/**
	 * Sieve of eratosthenes
	 * 
	 * @param n
	 */
	public static void solve(int n) {
		boolean[] isPrime = new boolean[n];
		for (int i = 1; i < isPrime.length; i++) {
			isPrime[i] = true;
		}

		// Iterate only till Math.sqrt(n).
		// Example: 
		// n = 25
		// sqrt(25) = 5
		// we iterate i only till 5. Because we are looking for multiples of i:
		// i*2, i*3, i*4, i*5, i*6. If i were to be 7 then we would do 7*2, 7*3, 7*4, etc
		// which is the same as 2*7, 3*7, 4*7, etc. The second part we have already calculated 
		// for i<5. That is why we only need to go till sqrt(n).
		for (int i=2; i<Math.sqrt(n); i++) {
			if (isPrime[i]) {
				// remove all multiples of i
				for (int j=(i+i); j<n; j = j + i) {
					isPrime[j] = false;
				}
				
			}
		}
		
		
		for (int i=2; i<isPrime.length; i++) {
			if (isPrime[i]) {
				System.out.print(i+ "  ");
			}
		}

	}

	public static void main(String[] args) {
		solve(18);

	}

}
