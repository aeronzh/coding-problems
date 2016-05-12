package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The task is to find the length of the longest subsequence in a given array of integers such that all elements of the subsequence are sorted in ascending order. For example, the length of the LIS for { 15, 27, 14, 38, 26, 55, 46, 65, 85 } is 6 and the longest increasing subsequence is {15, 27, 38, 55, 65, 85}.
 * In this challenge you simply have to find the length of the longest strictly increasing sub-sequence of the given sequence.
 */
public class LongestIncreasingSubSeq {

    private static int lcs(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }


    private static int solve(int[] a) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : a) {
            set.add(i);
        }
        int[] sorteda = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            sorteda[index++] = i;
        }

        Arrays.sort(sorteda);
        int result = lcs(a, sorteda);
        return result;
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
