package exercises.bitmanipulation;

/**
 * Given an integer, print the next smallest and next largest number that have
 * the same number of 1 bits in their binary representation.
 * 
 * EXAMPLE
 * 
 * 33: 100001
 * 
 * 34: 100010
 * 
 * 36: 100100
 * 
 * @author lucas
 *
 */
public class E3 {

	/**
	 * Start from the least significant bit and move towards the most
	 * significant until we find the first '1'. Flip the previous '0' and flip
	 * the '1' to '0'.
	 * 
	 * @param n
	 * @return
	 */
	public static int findSmallest(int n) {
		int mask = 1;
		int index = 0;
		while ((n & mask) == 0) {
			mask = mask << 1;
			index++;
		}

		// Set index to zero
		mask = ~mask;
		n = n & mask;

		// set index - 1 to 1
		mask = 1 << (index - 1);
		n = n | mask;

		return n;
	}

	/**
	 * Start from the least significant bit and move towards the most
	 * significant until we find the first '1'. Flip the '1'. Then continue
	 * until the next '0' and flip it.
	 * 
	 * @param n
	 * @return
	 */
	public static int findLargest(int n) {
		int mask = 1;
		int index = 0;
		while ((n & mask) == 0) {
			mask = mask << 1;
			index++;
		}

		//System.out.println("Before mask: " + Integer.toBinaryString(n));
		mask = ~mask;
		n = n & mask;

		mask = 1 << (index + 1);
		while ((n & mask) == 1) {
			mask = mask << 1;
			index++;
		}
		mask = 1 << (index + 1);
		n = n | mask;

		return n;
	}

}
