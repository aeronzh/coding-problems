package problems;

import java.util.*;

/**
 * Created by lucas on 18/02/16.
 */
public class SegmentTree {
    long tree[];

    SegmentTree(int arr[], int n) {
        int log = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int size = 2 * (int) Math.pow(2, log) - 1;
        tree = new long[size];
        Arrays.fill(tree, -1);
        construct(arr, 0, n - 1, 0);
    }

    private long construct(int elements[], int intervalStart, int intervalEnd, int nodeIndex) {
        if (intervalStart == intervalEnd) {
            tree[nodeIndex] = elements[intervalStart];
            return elements[intervalStart];
        }
        int mid = middle(intervalStart, intervalEnd);
        tree[nodeIndex] = Math.min(construct(elements, intervalStart, mid, nodeIndex * 2 + 1), construct(elements, mid + 1, intervalEnd, nodeIndex * 2 + 2));
        return tree[nodeIndex];
    }

    int middle(int start, int end) {
        return start + (end - start) / 2;
    }

    long getMin(int intervalStart, int intervalEnd, int searchStart, int searchEnd, int nodeIndex) {
        if (searchStart <= intervalStart && intervalEnd <= searchEnd)
            return tree[nodeIndex];

        if (intervalEnd < searchStart || intervalStart > searchEnd)
            return Integer.MAX_VALUE;

        int mid = middle(intervalStart, intervalEnd);
        return Math.min(getMin(intervalStart, mid, searchStart, searchEnd, 2 * nodeIndex + 1), getMin(mid + 1, intervalEnd, searchStart, searchEnd, 2 * nodeIndex + 2));
    }

    long getMin(int n, int start, int end) {
        long result = getMin(0, n - 1, start, end, 0);
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 1, 6, 9, 10, 11, 23, 1, 7, 9};
        int n = arr.length;

        SegmentTree tree = new SegmentTree(arr, n);
    }
}
