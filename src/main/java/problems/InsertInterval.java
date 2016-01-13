package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping & sorted intervals, insert a new interval into
 * the intervals (merge if necessary).
 * 
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * 
 * @author lucas
 *
 */
public class InsertInterval {

	public static void print(List<Integer[]> intervals) {
		for (Integer[] i : intervals) {
			System.out.print("[" + i[0] + ", " + i[1] + "] ");
		}
	}

	public static List<Integer[]> solve(List<Integer[]> intervals, Integer[] n) {
		List<Integer[]> result = new ArrayList<Integer[]>();

		int size = intervals.size();
		Integer[] interval = intervals.get(0);
		while (size > 0) {

			if (interval[1] < n[0]) {
				result.add(interval);
				intervals.remove(0);
				interval = intervals.get(0);
			} else if (n[1] < interval[0]) {
				result.add(n);
				result.addAll(intervals);
				return result;
			} else if ((n[0] >= interval[0] && n[0] <= interval[1]) || (n[1] >= interval[0] && n[1] <= interval[1])) {
				n = new Integer[] { Math.min(n[0], interval[0]), Math.max(n[1], interval[1]) };
				intervals.remove(0);
				interval = intervals.get(0);
			} else if (n[0] < interval[0] && n[1] > interval[1]) {
				intervals.remove(0);
				if (intervals.size() > 0) {
					interval = intervals.get(0);
				}
			} else {
				intervals.remove(0);
				if (intervals.size() > 0) {
					interval = intervals.get(0);
				}
			}

			size = intervals.size();
		}

		if (result.isEmpty()) {
			result.add(n);
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer[]> intervals = new ArrayList<Integer[]>();
		Integer[] a = { 1, 2 };
		Integer[] b = { 3, 5 };
		Integer[] c = { 6, 7 };
		Integer[] d = { 8, 10 };
		Integer[] e = { 12, 16 };

		intervals.add(a);
		intervals.add(b);
		intervals.add(c);
		intervals.add(d);
		intervals.add(e);

		Integer[] n = { 4, 9 };

		//		Integer[] a = { 1, 3 };
		//		Integer[] b = { 6, 9 };
		//		intervals.add(a);
		//		intervals.add(b);
		//
		//		Integer[] n = { 0, 2};

		List<Integer[]> result = solve(intervals, n);

		print(result);
	}

}
