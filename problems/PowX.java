package problems;

/**
 * Implement pow(x, n).
 * 
 * @author lucas
 *
 */
public class PowX {

	public static double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}

		// divide into sub problems of half the size
		// e.g.: 6^5 = 6^2 * 6^2 * 6
		double t = pow(x, n / 2);
		if (n % 2 == 0) {
			return t * t;
		} else {
			if (n > 0) {
				return t * t * x;
			} else {
				//5^-3 = 1 ÷ 5 ÷ 5 ÷ 5
				//5^-3 could also be calculated like: 1 ÷ (5 × 5 × 5) 
				return (t * t) / x;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(pow(5, 2));
	}

}
