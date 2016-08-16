package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Emma is playing a new mobile game involving clouds numbered from 0 to n-1 . A
 * player initially starts out on cloud c_0, and they must jump to cloud
 * c_(n-1). In each step, she can jump from any cloud i to cloud i+1 or cloud
 * i+2.
 * 
 * There are two types of clouds, ordinary clouds and thunderclouds. The game
 * ends if Emma jumps onto a thundercloud, but if she reaches the last cloud
 * (i.e. c_(n-1) ), she wins the game!
 * 
 * 
 * Can you find the minimum number of jumps Emma must make to win the game? It
 * is guaranteed that clouds c_0 and c_(n-1) are ordinary-clouds and it is
 * always possible to win the game.
 * 
 * 
 * Input Format
 * 
 * The first line contains an integer,n (the total number of clouds). The second
 * line contains n space-separated binary integers describing clouds c_0, c_1,
 * ..., c_(n-1).
 * 
 * If c_i = 0, the ith cloud is an ordinary cloud.
 * 
 * If c_i == 1 , the ith cloud is a thundercloud.
 * 
 * 
 * Output Format
 * 
 * Print the minimum number of jumps needed to win the game.
 * 
 * @author lucas
 *
 */
public class JumpingOnTheClouds {
	
	private static int brute(int[] c, int n, int current, int steps) {
		if (current >= n-1) {
			return steps;
		}
		
		if (c[current] == 1) {
			// loose
			return Integer.MAX_VALUE;
		}
		
		
		// jump to i+1
		int a = brute(c, n, current+1, steps+1);
		
		
		// jump to i+2
		int b = brute(c, n, current+2, steps+1);
		
		return Math.min(a, b);
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] c = new int[n];

		for (int i = 0; i < n; i++) {
			c[i] = in.nextInt();
		}
		
		System.out.println(brute(c, n, 0, 0));
	}
}
