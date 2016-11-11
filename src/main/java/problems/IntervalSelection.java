package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IntervalSelection {
	private static class Interval implements Comparable {
		int start;
		int end;

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "[" + start + ", " + end + "]";
		}

		/**
		 * compareTo Returns: "the value 0 if the argument string is equal to
		 * this string; a value less than 0 if this string is lexicographically
		 * less than the string argument; and a value greater than 0 if this
		 * string is lexicographically greater than the string argument."
		 */
		@Override
		public int compareTo(Object o) {
			Interval other = (Interval) o;
			return this.end - other.end;
		}
	}


	/**
	 * The greedy solution is pretty straightforward, very similar to the Job
	 * Selection Problem, with the additional check that when adding a new
	 * interval it must not break the condition.
	 * 
	 * https://en.wikipedia.org/wiki/Activity_selection_problem
	 * http://stackoverflow
	 * 
	 * @param intervals
	 */
	private static void greedy(List<Interval> intervals) {
		Collections.sort(intervals);

		List<Interval> ans = new ArrayList<Interval>();
		int last = 0;
		ans.add(intervals.get(last));

		int n = intervals.size();
		for (int i = 1; i < n; i++) {
			if (fulfillsCondition(ans, intervals.get(i))) {
				ans.add(intervals.get(i));
				last = i;
			}
		}

		System.out.println(ans.size());

	}

	private static boolean fulfillsCondition(List<Interval> intervals, Interval other) {
		int count = 0;
		for (int i = 0; i < intervals.size(); i++) {
			int s = Math.max(other.start, intervals.get(i).start);
			int e = Math.min(other.end, intervals.get(i).end);
			Interval common = new Interval(s, e);

			for (int j = 0; j < intervals.size(); j++) {
				if (j != i) {
					int commonStart = Math.max(common.start, intervals.get(j).start);
					int commonEnd = Math.min(common.end, intervals.get(j).end);
					
					if (commonEnd >= commonStart) {
						count++;
					}

					if (count == 2) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = in.nextInt();
			List<Interval> intervals = new ArrayList<Interval>();
			for (int i = 0; i < n; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				intervals.add(new Interval(start, end));
			}

			greedy(intervals);
		}
	}
}
