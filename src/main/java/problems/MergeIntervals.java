package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Merge Overlapping Intervals Given a set of time intervals in any order, merge all overlapping intervals into one and
 * output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of
 * integers for simplicity.
 * <p>
 * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} overlap
 * with each other, so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become
 * {5, 8}
 */
public class MergeIntervals {
    private static List<Integer[]> merge(List<Integer[]> intervals) {
        List<Integer[]> ans = new ArrayList<>();

        // Sort in ASC order depending on their ending time.
        Collections.sort(intervals, new Comparator<Integer[]>() {

            /**
             * This method returns zero if the objects are equal.
             * It returns a positive value if interval1 is greater than interval2.
             * Otherwise, a negative value is returned.
             */
            @Override
            public int compare(Integer[] interval1, Integer[] interval2) {
                return interval1[1] - interval2[1];
            }
        });


        int n = intervals.size();
        Integer[] cur = intervals.get(0);
        int i = 1;
        while (i < n) {
            Integer[] next = intervals.get(i);
            while (next[0] <= cur[1] && i < intervals.size()) {
                cur[0] = Math.min(cur[0], next[0]);
                cur[1] = next[1];

                i++;
                if (i < intervals.size()) {
                    next = intervals.get(i);
                }

            }

            ans.add(cur);
            cur = next;
        }


        return ans;
    }


    public static void main(String[] args) throws FileNotFoundException {
        List<Integer[]> intervals = new ArrayList<>();
        intervals.add(new Integer[]{6, 8});
        intervals.add(new Integer[]{2, 4});
        intervals.add(new Integer[]{1, 3});
        intervals.add(new Integer[]{5, 5});
        intervals.add(new Integer[]{-1, 4});
        intervals.add(new Integer[]{3, 4});
        intervals.add(new Integer[]{6, 8});
        intervals.add(new Integer[]{8, 10});
        intervals.add(new Integer[]{11, 11});

        System.out.println("Not merged:");
        for (Integer[] interval : intervals) {
            System.out.print("{" + interval[0] + "," + interval[1] + "} ");
        }


        List<Integer[]> result = merge(intervals);

        System.out.println("\n\nMerged:");
        for (Integer[] interval : result) {
            System.out.print("{" + interval[0] + "," + interval[1] + "} ");
        }

    }
}
