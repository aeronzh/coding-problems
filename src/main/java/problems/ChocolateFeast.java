package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Little Bobby loves chocolate, and he frequently goes to his favorite store,
 * Penny Auntie, with n dollars to buy chocolates. Each chocolate has a flat
 * cost of c dollars, and the store has a promotion where they allow you to
 * trade in m chocolate wrappers in exchange for 1 free piece of chocolate.
 * 
 * For example, if m=2 and Bobby has n=4 dollars that he uses to buy 4
 * chocolates at c=1 dollar apiece, he can trade in the 4 wrappers to buy more
 * chocolates. Now he has 2 more wrappers that he can trade in for 1 more
 * chocolate. Because he only has 1 wrapper left at this point and 1<m, he was
 * only able to eat a total of 7 pieces of chocolate.
 * 
 * Given n, c, and m for t trips to the store, can you determine how many
 * chocolates Bobby eats during each trip?
 * 
 * @author lucas
 *
 */
public class ChocolateFeast {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int c = in.nextInt();
			int m = in.nextInt();
			
			int chocolates = n/c;
			int wrappers = chocolates;
			while (wrappers >= m) {
				chocolates += (wrappers/m);
				wrappers = (wrappers/m) + (wrappers%m);
			}
			
			System.out.println(chocolates);
			
		}
	}
}
