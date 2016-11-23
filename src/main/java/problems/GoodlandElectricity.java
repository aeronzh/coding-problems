package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Help the goverment by finding and printing the minimum number of towers they
 * must switch on to ensure that all Goodland's cities have electricity. If this
 * task is not possible for the given value of and configuration of towers,
 * print -1.
 * 
 * 6 2
 * 
 * 0 1 1 1 1 0
 * 
 * 0 1 2 3 4 5
 * 
 * _ 1 _ _ 1 _
 * 
 * [0,2] [1,3] [2,4] [3,5]
 * 
 * 0,3 1,4 2
 * 
 * [0,2]
 * 
 * 
 * 6 2
 * 
 * 1 1 1 0 0 1
 * 
 * 1 _ 1 _ _ 1
 * 
 * [0,1] [0,2] [1,3] [4,5]
 * 
 * 
 * [0,1] [4,5]
 * 
 * @author lucas
 * 
 */
public class GoodlandElectricity {

	private static int solve(int n, int k, boolean[] hasTower) {
		int count = 0;

		int[] previousTowerFor = new int[n]; // previousTowerFor[i] holds index of the preceding tower or i if i is a tower.
		int last = -1;
		for (int i = 0; i < n; i++) {
			if (hasTower[i]) {
				last = i;
			}
			previousTowerFor[i] = last;
		}

		int city = 0;
		while (city < n) {
			// A tower can be at most k - 1 distance from city. When looking at previousTowerFor[city + k - 1]
			// we get the right-most tower from city (since previousTowerFor[city + k - 1] holds the latest tower to the left of index city + k - 1).
			int tower = previousTowerFor[Math.min(city + k - 1, n - 1)];

			if (tower == -1 | city - tower >= k) {
				return -1;
			} else {
				// We found a tower within k distance of city.
				// Jump to next city that requires a tower. Since tower can cover k-1 cities, we jump to city = tower + k.
				city = tower + k;
				count++;
			}

		}

		return count;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		boolean[] hasTower = new boolean[n];
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			hasTower[i] = t == 1;
		}

		System.out.println(solve(n, k, hasTower));
	}
}
