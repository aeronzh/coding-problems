package exercises.bitmanipulation;

/**
 * Write a program to swap odd and even bits in an integer with as few
 * instructions as possible (e g , bit 0 and bit 1 are swapped, bit 2 and bit 3
 * are swapped, etc).
 * 
 * @author lucas
 *
 */
public class E6 {

    /**
     * We need to right shift (>>) all even bits by 1 so that they become odd bits,
     * and left shift (<<) all odd bits by 1 so that they become even bits.
     *
     * @param n
     */
    public static int solve(int n) {
        // Get all even bits of n
        int evenBits = n & 0xAAAAAAAA; // n & 10..101010

        // Get all odd bits of n
        int oddBits  = n & 0x55555555; // n & 01..010101

        // Shift evenBits to the right
        evenBits = evenBits >> 1;

        // Shift oddBits to the left
        oddBits = oddBits << 1;

        // Combine
        return evenBits | oddBits;
    }

	public static void main(String[] args) {
        int n = 21;
        System.out.println("n: " + Integer.toBinaryString(n));
		int result = solve(n);
        System.out.println("result: " + Integer.toBinaryString(result));
	}

}
