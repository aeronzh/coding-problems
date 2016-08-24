package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Aerith is playing a cloud game! In this game, there are clouds numbered
 * sequentially from 0 to n-1. Each cloud is either an ordinary cloud or a
 * thundercloud.
 * 
 * Aerith starts out on cloud 0 with energy level E=100. She can use 1 unit of
 * energy to make a jump of size k to cloud (i+k)%n until she gets back to cloud
 * 0. If Aerith lands on a thundercloud, her energy (E) decreases by 2
 * additional units. The game ends when Aerith lands back on cloud 0.
 * 
 * Given the values of n, k, and the configuration of the clouds, can you
 * determine the final value of E after the game ends?
 * 
 * Note: Recall that % refers to the modulo operation.
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers, n (the number of
 * clouds) and k (the jump distance), respectively.
 * 
 * The second line contains n space-separated integers describing the respective
 * values of clouds c_0, c_1, ..., c_(n-1) . Each cloud is described as follows:
 * 
 * If c_i = 0, then cloud i is an ordinary cloud.
 * 
 * If c_i = 1, then cloud i is a thundercloud.
 * 
 * @author lucas
 *
 */
public class JumpingOnTheClouds2 {

	private static void solve(int[] c, int n, int k) {
		int e = 100;
		for (int i = 0; i <= n; i = i + k) {
			if (c[i] == 0) {
				e--;
			} else {
				e -= 3;
			}

			if ((i + k) % n == 0) {
				break;
			}
		}

		System.out.println(e);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();
		int[] c = new int[n];

		for (int i = 0; i < n; i++) {
			c[i] = in.nextInt();
		}

		solve(c, n, k);
	}

}
