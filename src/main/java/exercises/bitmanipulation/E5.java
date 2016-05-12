package exercises.bitmanipulation;

/**
 * Write a function to determine the number of bits required to convert integer
 * A to integer B.
 * 
 * Input: 31, 14
 * 
 * Output: 2
 * 
 * @author lucas
 *
 */
public class E5 {

	public static void main(String[] args) {
		for (int n = 0; n < 30; n++) {
			System.out.println(n + ": " + Integer.toBinaryString(n));
		}

	}

}
