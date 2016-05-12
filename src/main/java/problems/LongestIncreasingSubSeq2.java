package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The task is to find the length of the longest subsequence in a given array of integers such that all elements of the subsequence are sorted in ascending order. For example, the length of the LIS for { 15, 27, 14, 38, 26, 55, 46, 65, 85 } is 6 and the longest increasing subsequence is {15, 27, 38, 55, 65, 85}.
 * In this challenge you simply have to find the length of the longest strictly increasing sub-sequence of the given sequence.
 */
public class LongestIncreasingSubSeq2 {


    private static int solve(int[] a) {
        int n = a.length;
        int[] l = new int[n]; // l[i] = length of longest increasing supsequence that end with a[i]
        l[0] = 1;
        for (int i = 1; i < n; i++) {
            // Search max{l[j] | j<i and a[j]<a[i]}
            int maxL = 0;
            for (int j = 0; j < i; j++) {
                if (l[j] >= maxL && a[j]<a[i]) {
                    maxL = l[j];
                }
            }

            l[i] = maxL + 1;
        }


        int max = l[0];
        for (int i=1; i<l.length; i++) {
            max = Math.max(max, l[i]);
        }

        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(solve(a));
    }
}
