package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * Bob has a strange counter. At the first second, t=1 , it displays the number
 * 3. At each subsequent second, the number displayed by the counter decrements
 * by 1.
 * 
 * The counter counts down in cycles. In the second after the counter counts
 * down to 1, the number becomes 2x the initial number for that countdown cycle
 * and then continues counting down from the new initial number in a new cycle.
 * The diagram below shows the counter values for each time t in the first three
 * cycles:
 * 
 * cycle 1:
 * 
 * t: 1 2 3
 * 
 * v: 3 2 1
 * 
 * 
 * cycle 2:
 * 
 * t: 4 5 6 7 8 9
 * 
 * v: 6 5 4 3 2 1
 * 
 * 
 * cycle 3:
 * 
 * t: 10 11 12 13 14 15 16 17 18 19 20 21
 * 
 * v: 12 11 10 ... 1
 * 
 * @author lucas
 *
 */
public class StrangeCounter {
	// in 999999766777
	// out 649267674885
	private static void solve(long t) {
		// 3 * 2 * 2 * .... * 2 = 3 * 2^(#cycles - 1)
		// find cycle
		long cycle = 1;
		long upperT = 3;
		long prevUpperT = 0;
		long two = 2;
		while (upperT<t) {
			prevUpperT = upperT;
			upperT = prevUpperT + 3*two;
			two *= 2;
			cycle++;
		}

		long lowerT = prevUpperT + 1;
		long diff = t - lowerT;
		long counter = lowerT + 2 - diff;
		System.out.println(counter);
		
	}
	
	private static void brute(long t) {
		// 3 * 2 * 2 * .... * 2 = 3 * 2^(#cycles - 1)
		// find cycle
		long cycle = 1;
		long counter = 3;
		long lowerT = counter - 2;
		long upperT = lowerT + counter - 1;
		while (upperT<t) {
			counter = 3 * (2 << (cycle-1));
			
			lowerT = counter - 2;
			upperT = lowerT + counter - 1;
			
			cycle++;
		}
		
		long diff = t - lowerT;
		counter = lowerT + 2 - diff;
		System.out.println(counter);
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		long t = in.nextLong();
		
		solve(t);
		
	}
}
