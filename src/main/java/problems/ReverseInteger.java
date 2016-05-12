package problems;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * 
 * Example2: x = -123, return -321
 * 
 * @author ex45141
 *
 */
public class ReverseInteger {

	public static int solve(int n) {
		boolean negative = n<0;
		n = Math.abs(n);
		
		int d = 1;
		while (n / d > 10) {
			d = d * 10;
		}

		int sum = 0;
		while (d > 0) {
			int right = n % 10;
			sum = sum + (right * d);
			d = d/10;
			n = n/10;
		}

		if (negative) {
			sum = sum * -1;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(solve(23));

	}

}
