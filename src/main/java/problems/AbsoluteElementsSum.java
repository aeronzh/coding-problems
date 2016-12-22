package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AbsoluteElementsSum {
    private static final int MIN = -2000;
    private static final int MAX = 2000;

    private static int[] sort(int[] a) {
        final int OFFSET = Math.abs(MIN);
        int[] countLessEq = new int[2 * MAX + 2];
        int[] count = new int[2 * MAX + 2];

        int n = a.length;

        for (int i = 0; i < n; i++) {
            count[OFFSET + a[i]] = count[OFFSET + a[i]] + 1;
            countLessEq[OFFSET + a[i]] = countLessEq[OFFSET + a[i]] + 1;
        }

        for (int i = MIN + 1; i <= MAX; i++) {
            countLessEq[OFFSET + i] = countLessEq[OFFSET + i] + countLessEq[OFFSET + i - 1];
        }

        int[] position = new int[2 * MAX + 2];
        Arrays.fill(position, -1);
        for (int i = 0; i < n; i++) {
            if (position[OFFSET + a[i]] == -1) {
                position[OFFSET + a[i]] = countLessEq[OFFSET + a[i]] - count[OFFSET + a[i]];
            } else {
                position[OFFSET + a[i]] = position[OFFSET + a[i]] + 1;
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = position[OFFSET + a[i]] - count[OFFSET + a[i]] + 1;
            result[pos] = a[i];
            count[OFFSET + a[i]] = count[OFFSET + a[i]] - 1;
        }

        return result;
    }

    /**
     * Returns an index pointing to the first element in the range [first, last] that is greater or equal to value or
     * last if no such element is found.
     */
    private static int lowerBound(int[] a, int first, int last, long value) {
        if (first >= last) {
            if (a[first] >= value) {
                return first;
            } else {
                return -1;
            }
        } else {
            int mid = first + (last - first) / 2;
            if (a[mid] >= value) {
                // Element is found --> search leftward until you find a non-matching element.
                return lowerBound(a, first, mid, value);
            } else {
                return lowerBound(a, mid + 1, last, value);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);
        Scanner out = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

        int n = in.nextInt();
        int[] a = new int[n];

        // Read input
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        // Sort array
        a = sort(a);

        // Compute prefix sum
        long[] prefixSum = new long[n];
        prefixSum[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        int queries = in.nextInt();
        long add = 0;
        for (int q = 0; q < queries; q++) {
            long x = in.nextLong();

            add += x;

            int lo = lowerBound(a, 0, n - 1, -1 * add);

            long ans = 0;
            if (lo > 0) {
                ans = Math.abs(prefixSum[lo - 1] + lo * add) + (prefixSum[n - 1] - prefixSum[lo - 1]) + (n - lo) * add;
            } else {
                ans = Math.abs(prefixSum[n - 1] + n * add);
            }

            long expected = out.nextLong();
            if (expected != ans) {
                System.out.println("Expected " + expected + " got " + ans);
            } else {
                System.out.println(ans);
            }
        }
    }
}
