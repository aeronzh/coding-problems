package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Mark and Jane are very happy after having their first kid. Their son is very
 * fond of toys, so Mark wants to buy some. There are N different toys lying in
 * front of him, tagged with their prices, but he has only $K. He wants to
 * maximize the number of toys he buys with this money.
 * 
 * Now, you are Mark's best friend and have to help him buy as many toys as
 * possible.
 * 
 * Input Format
 * 
 * The first line contains two integers, N and K, followed by a line containing
 * N space separated integers indicating the products' prices.
 * 
 * Output Format
 * 
 * An integer that denotes maximum number of toys Mark can buy for his son.
 * 
 * Constraints 1≤N≤10^5
 * 
 * 1≤K≤10^9
 * 
 * 1≤price of any toy≤10^9
 * 
 * A toy can't be bought multiple times.
 * 
 * Sample Input
 * 
 * 7 50
 * 
 * 1 12 5 111 200 1000 10
 * 
 * 
 * Sample Output
 * 
 * 4
 * 
 * Explanation
 * 
 * He can buy only 4 toys at most. These toys have the following prices:
 * 1,12,5,10.
 * 
 * @author lucas
 *
 */
public class MarkAndToys {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] p = new int[n];

		// increasing sub seq. with all k.
		for (int i = 0; i < n; i++) {
			p[i] = scanner.nextInt();
		}

		Arrays.sort(p);
		
		int count = 0;
		int i = 0;
		while (k>=0) {
			count++;
			k -= p[i++];
		}
		
		if (k<0) {
			count--;
		}
		
		System.out.println(count);
	}

}
