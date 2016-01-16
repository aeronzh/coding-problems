package problems;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number. The digits are stored such that the most significant digit is at
 * the head of the list.
 * 
 * @author lucas
 *
 */
public class PlusOne {

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
		System.out.println();
	}

	public static int[] solve(int[] n) {
		int[] result = new int[n.length + 1];

		for (int i = n.length - 1; i >= 0; i--) {
			result[i + 1] = n[i];
		}

		int carry = 0;
		int i = result.length - 1;
		int d = result[i] + 1 + carry;
		if (d >= 10) {
			carry = 1;
			d = d % 10;
		} else {
			carry = 0;
		}
		result[i] = d;

		while (i > 0 && carry == 1) {
			i--;
			d = result[i] + carry;
			if (d >= 10) {
				carry = 1;
				d = d % 10;
			} else {
				carry = 0;
			}
			result[i] = d;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] n = new int[] { 9 };

		int[] result = solve(n);
		print(result);
	}

}
