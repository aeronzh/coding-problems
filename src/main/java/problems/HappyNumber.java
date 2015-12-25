package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Write an algorithm to determine if a number is "happy".
 * 
 * What is an happy number can be shown in the following example:
 * 
 * 19 is a happy number
 * 
 * 1^2 + 9^2 = 82
 * 
 * 8^2 + 2^2 = 68
 * 
 * 6^2 + 8^2 = 100
 * 
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * @author lucas
 *
 */
public class HappyNumber {

	public static boolean solve(int n) {
		Set<Integer> set = new HashSet<Integer>();

		while (!set.contains(n)) {
			set.add(n);
			
			int sum = 0;
			while (n > 0) {
				int d = n % 10;
				n = n / 10;
				sum += Math.pow(d, 2);
			}
			
			if (sum == 1) {
				return true;
			}
			
			n = sum;
		}


		return false;
	}

	public static void main(String[] args) {
		System.out.println(solve(19));

	}

}
