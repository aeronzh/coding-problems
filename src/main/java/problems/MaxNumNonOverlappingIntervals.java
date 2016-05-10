package problems;

import java.util.Arrays;

/**
 * Given an array of intervals, return max number of non-overlapping intervals
 * 
 * @author lucas
 *
 */
public class MaxNumNonOverlappingIntervals {

	private static class Interval implements Comparable {
		int begin;
		int end;

		public Interval(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}

		public int compareTo(Object other) {
			if (!(other instanceof Interval)) {
				throw new ClassCastException("An Interval object expected.");
			}

			int otherEnd = ((Interval) other).end;
			return this.end - otherEnd;
		}

		@Override
		public String toString() {
			return "[" + begin + ", " + end + "]";
		}

	}

	/**
	 * 1. Sorts in increasing order of finish times the array of activities A by
	 * using the finish times stored in the array intervals. This operation can
	 * be done in O(nlogn) time, using for example merge sort, heap sort, or
	 * quick sort algorithms.
	 * 
	 * Note that, since the intervals has already been sorted according to the
	 * finish times in intervals, intervals[0] is the activity with the smallest
	 * finish time.
	 * 
	 * 
	 * 2. Creates a variable 'cursor' that keeps track of the index of the last
	 * selected activity.
	 * 
	 * 3. If the start time intervals[i].begin of the ith activity (intervals[i]) is greater or equal
	 * to the finish time 'cursor' of the last selected activity, then intervals[i]
	 * is compatible to the selected activities, and thus it can be selected.
	 * 
	 * @param intervals
	 * @return
	 */
	private static int nonOverlapping(Interval[] intervals) {
		// Sort by end time
		Arrays.sort(intervals);

		for (int i = 0; i < intervals.length; i++) {
			System.out.print(intervals[i]);
		}
		System.out.println();

		int ans = 0;
		int cursor = intervals[0].begin;
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i].begin >= cursor) {
				ans++;
				cursor = intervals[i].end;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Interval[] intervals = { new Interval(800, 900), new Interval(900, 1100), new Interval(900, 1130), new Interval(1030, 1400), new Interval(1230, 1400),
				new Interval(810, 830) };

		System.out.println(nonOverlapping(intervals));

	}

}
