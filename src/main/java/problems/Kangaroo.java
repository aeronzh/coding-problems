package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * There are two kangaroos on an x-axis ready to jump in the positive direction
 * (i.e, toward positive infinity). The first kangaroo starts at location x1 and
 * moves at a rate of v1 meters per jump. The second kangaroo starts at location
 * x2 and moves at a rate of meters v2 per jump. Given the starting locations
 * and movement rates for each kangaroo, can you determine if they'll ever land
 * at the same location at the same time?
 * 
 * Input Format
 * 
 * A single line of four space-separated integers denoting the respective values
 * of x1, v1, x2, and v2.
 * 
 * @author lucas
 *
 */
public class Kangaroo {

	// 0 3 4 2
	
	// 14 4 98 2
	
	// condition to meet:  x1 + t*v1 == x2 + t*v2  ==> x2 - x1 == (v1 - v2)*t ==> return YES if (x2 -x1) % (v1 - v2) == 0
	public static void solve(int x1, int v1, int x2, int v2) {
		if (v2 >= v1) {
			System.out.println("NO");
		} else {
			if ((x2 - x1) % (v1 - v2) == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();

		solve(x1, v1, x2, v2);
	}

}
