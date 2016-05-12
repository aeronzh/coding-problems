package exercises.bitmanipulation;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j
 * Write a method to set all bits between i and j in N equal to M (e g , M
 * becomes a substring of N located at i and starting at j).
 * 
 * EXAMPLE:
 * 
 * Input: N = 1000 00000 00, M = 10101, i = 2, j = 6
 * 
 * Output: N= 1000 10101 00
 * 
 * @author lucas
 *
 */
public class E1 {

	public static void setBits(int n, int m, int i, int j) {
		if (j < i) {
			throw new IllegalArgumentException("j must be greater equal to i");
		}

		// Zero out positions i - j in N
		int mask = (1 << (j - i) + 1) - 1;
		mask = mask << i;
		mask = ~mask;
		n = n & mask;

		// Set positions i - j to M
		m = m << i;
		n = n | m;

	}

	public static void main(String[] args) {
		setBits(2048, 13, 2, 3);

	}
}
