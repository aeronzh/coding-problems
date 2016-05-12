package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucas on 27/02/16.
 */
public class LongestCommonSubSequence {


    public static String solve(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        String[][] dp = new String[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = "";
            }
        }



        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + a[i-1];
                } else {
                    if (dp[i][j-1].length() > dp[i-1][j].length()) {
                        dp[i][j] = dp[i][j-1];
                    } else if (dp[i][j-1].length() <= dp[i-1][j].length()) {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                //System.out.println("dp["+i+"]["+j+"]="+dp[i][j]);
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 1};
//        int[] b = {3, 4, 1, 2, 1, 3};

        int[] a = {3,9,3,9};
        int[] b = {3,3,9};
        System.out.println(solve(a,b));
    }
}
