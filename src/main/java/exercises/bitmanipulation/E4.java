package exercises.bitmanipulation;

/**
 * Explain what the following code does: ((n & (n-1)) == 0).
 * 
 * @author lucas
 *
 */
public class E4 {

	/*
	 * It basically checks if n is a power of 2. Example n = 8 (1000) then n-1 =
	 * 7 will be 111 in binary format. --> n & (n-1) = 0
	 */

	public static void main(String[] args) {
		for (int n = 0; n < 30; n++) {
			if ((n & (n - 1)) == 0) {
				System.out.println(n);
				System.out.println(n + ": " + Integer.toBinaryString(n));
			}
		}

	}
}
