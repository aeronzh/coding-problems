package problems;

import java.math.BigInteger;

/**
 * Given an integer N find the next largest integer X that has the same number
 * of one bits in its binary representation.
 * 
 * @author lucas
 *
 */
public class FindNextLargestInteger {

	/**
	 * Rough algorithm : start scanning from right side: 00001100 <--
	 * 
	 * 
	 * Stop at the first 0 bit preceded by a set bit: 000 0 1100
	 * 
	 * 
	 * Swap this 0 bit with the preceded set bit: 000 0 1 100 ---swap---> 000 1
	 * 0 100
	 * 
	 * 
	 * Starting from the indicated position 00010 ->100 , push all 1's to as
	 * right as possible.
	 * 
	 * 
	 * Ans -> 00010001
	 * 
	 * @param num
	 * @return
	 */
	private static BigInteger solve(BigInteger num) {
		int index = 0;
		int lastOneIndex = 0;

		// Find first occurring 1
		while (!num.testBit(index)) {
			index++;
		}

		lastOneIndex = index;

		// Find the next 0
		while (num.testBit(index)) {
			index++;
		}

		// Set the 0 to 1
		num = num.setBit(index);

		index--;

		// Set the previous 1 to 0
		num = num.clearBit(index);

		System.out.println("Swap: " + num.toString(2));

		// Shift right 1s to the right
		//System.out.println("[" + (index - 1) + ", " + lastOneIndex + "]");

		for (int i = lastOneIndex; i < index; i++) {
			num = num.setBit(i - lastOneIndex);
			num = num.clearBit(i);
		}

		return num;
	}

	public static void main(String[] args) {
		BigInteger num = new BigInteger("46");
		System.out.println("Num: " + num + " - " + num.toString(2));

		BigInteger next = solve(num);

		System.out.println("Next: " + next + " - " + next.toString(2));
	}

}
