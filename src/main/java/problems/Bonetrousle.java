package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Once upon a time, Papyrus the skeleton went to buy some pasta from the store.
 * The store's inventory is bare-bones and they only sell one thing — boxes of
 * uncooked spaghetti! The store always stocks exactly k boxes of pasta, and
 * each box is numbered sequentially from 1 to k. This box number also
 * corresponds to the number of sticks of spaghetti in the box, meaning the
 * first box contains 1 stick, the second box contains 2 sticks, the third box
 * contains 3 sticks, …, and the kth box contains k sticks. Because they only
 * stock one box of each kind, the store has a tendon-cy to sell out of
 * spaghetti.
 * 
 * During each trip to the store, Papyrus likes to buy exactly n sticks of
 * spaghetti by purchasing exactly b boxes (no more, no less). Not sure which
 * boxes to purchase, Papyrus calls Sherlock Bones for help but he's also
 * stumped! Do you have the guts to solve this puzzle?
 * 
 * Given the values of n, k, and b for t trips to the store, determine which
 * boxes Papyrus must purchase during each trip. For each trip, print a single
 * line of b distinct space-separated integers denoting the box number for each
 * box of spaghetti Papyrus purchases (recall that the store only has one box of
 * each kind). If it's not possible to buy n sticks of spaghetti by purchasing b
 * boxes, print -1 instead.
 * 
 * Input Format
 * 
 * The first line contains a single integer, t , denoting the number of trips to
 * the store. Each of the t subsequent lines describes a trip to the store in
 * the form of three space-separated integers describing the respective values
 * of n (the number of sticks to buy), k (the number of boxes the store has for
 * sale), and b (the number of boxes to buy) for that trip to the store.
 * 
 * Constraints
 * 
 * @author lucas
 *
 */
public class Bonetrousle {
	private static void solve(long n, long k, int b) {
		BigInteger N = new BigInteger(""+n);
		BigInteger B = new BigInteger(""+b);
		BigInteger K = new BigInteger(""+k);
		
		
		BigInteger max = new BigInteger("" + k);
		max = max.multiply(new BigInteger("" + (k + 1)));
		max = max.divide(new BigInteger("" + 2));

		BigInteger sub = new BigInteger("" + (k - b));
		sub = sub.multiply(new BigInteger("" + ((k - b) + 1)));
		sub = sub.divide(new BigInteger("" + 2));

		max = max.subtract(sub);

		// long max = (k * (k + 1)) / 2 - ((k - b) * ((k - b) + 1)) / 2;
		// long min = b * (b + 1) / 2;
		
		BigInteger min = new BigInteger("" + b);
		min = min.multiply(new BigInteger("" + (b + 1)));
		min = min.divide(new BigInteger("" + 2));
	
		
		if (min.compareTo(BigInteger.ZERO) < 0) {
			System.out.println("Overflow");
		}


		if (max.compareTo(N) < 0) {
			System.out.println("-1");
		} else {
			//long d = (n - min) / b;
			BigInteger d = (N.subtract(min)).divide(B);
			
			//long remain = (n - min) % b;
			long remain = ((N.subtract(min)).mod(B)).longValue();
			
			
			if (min.compareTo(N)>0) {
				System.out.println("-1");
				return;
			}

			StringBuilder sb = new StringBuilder();
			if (remain == 0) {
				for (long i = 1; i <= b; i++) {
					BigInteger I = new BigInteger(""+i);
					I = I.add(d);
					sb.append(I.toString() + " ");
				}
			} else {
				// We need to distribute the remain on some nodes. Since remain is always smaller than b,
				// we will distribute it (in addition to d) on the last remain nodes (b-remain).
				for (long i = 1; i <= b - remain; i++) {
					BigInteger I = new BigInteger(""+i);
					I = I.add(d);
					sb.append(I.toString() + " ");
				}
				for (long i = b - remain + 1; i <= b; i++) {
					BigInteger I = new BigInteger(""+i);
					I = I.add(d);
					I = I.add(BigInteger.ONE);
					sb.append(I.toString() + " ");
				}
			}

			String ans = sb.toString().trim();
			System.out.println(ans);
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		//		Scanner out = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			long n = in.nextLong();
			long k = in.nextLong();
			int b = in.nextInt();

			solve(n, k, b);

			//			String expected = out.nextLine();
			//			System.out.println("E: " + expected);
			//			System.out.println();
		}

	}

}
