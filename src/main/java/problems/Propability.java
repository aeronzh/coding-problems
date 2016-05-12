package problems;

/**
 * You have a function f1() that generates 0,1 with the equal probability. Write
 * a function f29() that generates a number between 0 and 29 with equal
 * probability.
 * 
 * @author lucas
 *
 */
public class Propability {

	private static int f1() {
		return (Math.random() < 0.5) ? 0 : 1;
	}

	public static void solve(int n) {
		int r = f1();
	}

	public static void main(String[] args) {
		int s = 0;
		for (int i = 0; i < 10; i++) {
			s += f1();
		}

		System.out.println(s);

	}

}
