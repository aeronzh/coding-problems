package problems;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author lucas
 *
 */
public class PalidromeNumber {

	/**
	 * Returns length of number
	 * 
	 * @param n
	 * @return
	 */
	private static int lenOfNumber(int n) {
		int count = 0;
		while (n > 0) {
			n /= 10;
			count++;
		}

		return count;
	}

	/**
	 * Return the ith digit (zero based).
	 * 
	 * @param n
	 * @param index
	 * @return
	 */
	private static int getIthDigitOfNumber(int n, int index) {
		int len = lenOfNumber(n);
		if (index >= len) {
			throw new IllegalArgumentException("Index out of bounds!");
		} else {

			int numOfDigitsToCutOff = len - index;
			int d = 0;
			while (numOfDigitsToCutOff > 0) {
				d = n % 10;
				n /= 10;
				numOfDigitsToCutOff--;
			}

			return d;
		}
	}

	/**
	 * Solution 1
	 * @param n
	 * @return
	 */
	public static boolean solve(int n) {
		int len = lenOfNumber(n);
		for (int i=0; i<len/2; i++) {
			if (getIthDigitOfNumber(n, i) != getIthDigitOfNumber(n, len-i-1)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/**
	 * Solution 2
	 * @param n
	 * @return
	 */
	public static boolean solve2(int n) {
		int d = 1;
		while (n/d>10) {
			d = d * 10;
		}
		
		while (d>0) {
			int left = (n/d)%10;
			int right = n%10;
			if (left != right) {
				return false;
			}
			
			n = n/10;
			d = d/100;
		}
		
		return true;
	}

	public static void main(String[] args) {
		int n = 12344321;
		System.out.println(solve2(n));

	}

}
