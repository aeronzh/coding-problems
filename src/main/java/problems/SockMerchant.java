package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * John's clothing store has a pile of n loose socks where each sock i is labeled
 * with an integer, ci, denoting its color. He wants to sell as many socks as
 * possible, but his customers will only buy them in matching pairs. Two socks, i
 * and j, are a single matching pair if ci=cj.
 * 
 * Given n and the color of each sock, how many pairs of socks can John sell?
 * 
 * @author lucas
 *
 */
public class SockMerchant {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		final int MAX = 100;
		int count[] = new int[MAX+1];
		for (int i = 0; i < n; i++) {
			int color = in.nextInt();
			count[color] = count[color] + 1;
		}
		
		int pairs = 0;
		for (int i=0; i<=MAX; i++) {
			pairs += count[i]/2;
		}
		
		System.out.println(pairs);
	}
}
