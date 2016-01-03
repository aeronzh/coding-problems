package problems;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author lucas
 *
 */
public class FactorialTrailingZeros {

	// depends on how many pairs 5s (since 2*5 = 10) occur in the factorial
	// 20! = 1*2*3*4*5*6*7*8*9*10*12*13*14*15*16*17*18*19*20 --> 1*(2)*3*(2*2)*(5)*(2*3)*7*(2*2*2)*9*(2*5)*(2*2*3)*13*(2*7)*(3*5)*(2*2*2*2)*17*(2*9)*19*(2*2*5)
	// --> 1*2*3*2*[2*5]*2*3*7*2*2*2*9*[2*5]*2*2*3*13*2*7*3*[5*2]*2*2*2*17*2*9*19*2*[2*5] == 4
	public static int solve(int n) {
		int count = 0;
		
		boolean two = false;
		boolean five = false;
		for (int i=1; i<=n; i++) {
			if (i%2 == 0) {
				two = true;
			}
			
			if (i%5 == 0) {
				five = true;
			}
			
			
			if (two && five) {
				count++;
				two = false;
				five = false;
			}
		}
		
		
		return count;
	}
	
	public static int trailingZeroes(int n) {
		if (n < 0)
			return -1;
	 
		int count = 0;
		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
	 
		return count;
	}

	public static void main(String[] args) {
		System.out.println(solve(25));
		System.out.println(trailingZeroes(25));
	}

}
