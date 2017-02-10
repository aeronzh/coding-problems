package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * n + x = n ^ x
 * @author lucas
 *
 */
public class SumVsXor {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		
		// n = 100 = 1100100
		// x = 
		
		//System.out.println(Long.toBinaryString(n));
		int zeros = 0;
		while (n>0) {
			if ((n & 1) == 0) {
	            zeros++;
	        }
			n = n >> 1;
		}
		

		long ans = 1l<<zeros;
		System.out.println(ans);
	}
}
