package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * There is a huge blanket on your bed but unfortunately it has N stains. You
 * cover them using a single, rectangular silk cloth. The silk is expensive,
 * which is why the rectangular piece needs to have the least area as possible.
 * You love this blanket and decide to minimize the area covering the stains.
 * You buy some cleaning liquid to remove the stains but sadly it isn't enough
 * to clean all of them. You can just remove exactly K stains. The rest of the
 * stains need to be covered using a single, rectangular fragment of silk cloth.
 * 
 * Let X denote the area of the smallest possible silk cloth that may cover all
 * the stains originally. You need to find the number of different ways in which
 * you may remove K stains so that the remaining N-K stains can be covered with
 * silk of area strictly less than X (We are looking for any configuration that
 * will reduce the cost).
 * 
 * Assume that each stain is a point and that the rectangle is aligned parallel
 * to the axes.
 * 
 * Input specification
 * 
 * The first line contains two integers N (1<=N<=1000) and K (0<=K<=N). Next
 * follow N lines, one for each stain. Each line contains two integers in the
 * form 'X Y', (0<=X,Y<100000), the coordinates of each stain into the blanket.
 * Each pair of coordinates is unique.
 * 
 * Output specification
 * 
 * Output a single integer. The remainder of the division by 1000000007 of the
 * answer.
 * 
 * Sample input
 * 
 * 5 2
 * 
 * 0 1
 * 
 * 3 3
 * 
 * 2 0
 * 
 * 0 3
 * 
 * 2 3
 * 
 * 
 * Sample output
 * 
 * 8
 * 
 * Hint
 * 
 * We can clean two spots. So removing any of the following set of stains will
 * lead us to a conbination that will need less amount of silk.(The numbers
 * refer to the indices of the stains in the input and they begin from 1).
 * 
 * 1, 4
 * 
 * 2, 1
 * 
 * 2, 3
 * 
 * 2, 4
 * 
 * 2, 5
 * 
 * 3, 1
 * 
 * 3, 4
 * 
 * 3, 5
 * 
 * So there are 8 ways.
 * 
 * @author lucas
 *
 */
public class CoveringTheStains {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[][] stains = new int[n][2];

		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			stains[i][0] = x;
			stains[i][1] = y;
		}

	}

}
