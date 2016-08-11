package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// The triangle inequality states that for any triangle, the sum of the lengths of any two sides must be greater than or equal to the length of the remaining side
// The longest side must be shorter than the sum of the rest.

/**
 * A polygon is a closed shape with three or more sides. For example, triangles
 * are polygons. A polygon is non-degenerate if it has no overlapping sides (and
 * no sides of zero length).
 * 
 * You have sticks with positive integer lengths, a_0,a_1,...,a_(n-1) . You want to create a polygon
 * using all sticks. Because this is not always possible, you can cut one or
 * more sticks into two smaller sticks (they do not necessarily need to be of
 * integer length) and repeat the process of trying to create a polygon using
 * all the sticks. Given the lengths of all sticks, find and print the minimum
 * number of cuts necessary to make a non-degenerate polygon.
 * 
 * @author lucas
 *
 */
public class MakingPolygons {

	private static double sum(List<Double> l) {
		double sum = 0;

		for (double d : l) {
			sum += d;
		}

		return sum;
	}

	// 1 2 3
	private static void solve(List<Double> l) {
		int count = 0;

		Collections.sort(l);
		double max = l.get(l.size() - 1);
		double sum = sum(l) - max;
		l.remove(l.size() - 1);

		while (max >= sum) {
			count++;
			l.add(max / 2.0);
			l.add(max / 2.0);

			Collections.sort(l);
			max = l.get(l.size() - 1);
			sum = sum(l) - max;
			l.remove(l.size() - 1);
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(); // Guests
		List<Double> l = new ArrayList<Double>();
		for (int i = 0; i < n; i++) {
			l.add(in.nextDouble());
		}

		solve(l);

	}

}
