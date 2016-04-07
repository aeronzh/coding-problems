package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You and K−1 friends want to buy N flowers. Each flower fi has some cost ci.
 * The florist is greedy and wants to maximize his number of new customers, so
 * he increases the sale price of flowers for repeat customers; more precisely,
 * if a customer has already purchased x flowers, price P for fi is P_fi = (x+1)
 * * ci
 * 
 * Find and print the minimum cost for your group to purchase N flowers.
 * 
 * Note: You can purchase the flowers in any order.
 * 
 * Input Format
 * 
 * The first line contains two integers, N (number of flowers to purchase) and K
 * (the size of your group of friends, including you). The second line contains
 * N space-separated positive integers describing the cost (c0,c1,...,cN−2,cN−1)
 * for each flower fi .
 * 
 * Sample Input 0
 * 
 * 3 3
 * 
 * 2 5 6
 * 
 * Sample Output 0
 * 
 * 13
 * 
 * Sample Input 1
 * 
 * 3 2
 * 
 * 2 5 6
 * 
 * Sample Output 1
 * 
 * 15
 * 
 * Explanation
 * 
 * Sample Case 0:
 * 
 * There are 3 flowers and 3 people in your group. Each person buys one flower
 * and the sum of prices paid is 13 dollars, so we print 13.
 * 
 * Sample Case 1:
 * 
 * There are 3 flowers and 2 people in your group. The first person purchases 2
 * flowers, f0 and f1, in order of decreasing price; this means they buy the
 * more expensive flower first at price Pf1=(0+1)×5=5 dollars and the less
 * expensive flower second at price Pf0=(1+1)×2=4 dollars. The second person
 * buys the most expensive flower at price Pf2=(0+1)×6=6 dollars. We print the
 * sum of these purchases (5+4+6), which is 15.
 * 
 * @author lucas
 *
 */
public class GreedyFlorist {

	private static int solve(int flowers, int people, int[] c) {
		Arrays.sort(c);

		int[] purchases = new int[people];
		int sum = 0;
		int currentPerson = 0;
		int currentFlower = 0;
		if (flowers > people) {
			currentFlower = flowers - people;
		}

		int mod = c.length;
		while (flowers > 0) {
			sum = sum + (purchases[currentPerson] + 1) * c[currentFlower];
			currentFlower = (currentFlower + 1) % mod;
			if (currentFlower == 0) {
				currentFlower = Math.max(0, flowers - people - 1);
				mod -= people;
			}
			flowers--;
			purchases[currentPerson] = purchases[currentPerson] + 1;
			currentPerson = (currentPerson + 1) % people; // wrap arround
		}

		return sum;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int n, k;
		n = scanner.nextInt();
		k = scanner.nextInt();

		int c[] = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = scanner.nextInt();
		}

		int result = solve(n, k, c);
		System.out.println(result);

	}

}
