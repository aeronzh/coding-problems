package problems;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author lucas
 *
 */
public class NumberOfOneBits {

	private static int hammingWeight(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}

		return count;

	}

	public static void main(String[] args) {
		System.out.println(hammingWeight(11));

	}

}
