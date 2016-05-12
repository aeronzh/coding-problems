package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, which is common to both the sequences.
* <p/>
* Given two sequence of integers, A=[a1,a2,…,an] and B=[b1,b2,…,bm], find any one longest common subsequence.
* <p/>
* In case multiple solutions exist, print any of them. It is guaranteed that at least one non-empty common subsequence will exist.
*/
public class LongestCommonSubSeq {
    public static String solve(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        String[][] dp = new String[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = "";
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + a[i - 1] + " ";
                } else {
                    if (dp[i][j - 1].length() > dp[i - 1][j].length()) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (dp[i][j - 1].length() <= dp[i - 1][j].length()) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                //System.out.println("dp["+i+"]["+j+"]="+dp[i][j]);
            }
        }


        return dp[n][m];
    }


    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 7, 2, 4, 3, 1}, new int[]{1, 1, 2, 2, 3, 4, 7}));
    }
}
