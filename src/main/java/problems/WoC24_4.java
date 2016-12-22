package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WoC24_4 {

    // Longest Increasing Continuous Subsequence with difference 1 (e.g. 1,2,3 but not 1,2,4)
    public static int[] longestIncreasingContSubSq(int[] arr) {
        int subSeqLength = 1;
        int longest = 1;
        int indexStart = 0;
        int indexEnd = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] - 1)//We need to check if the current is equal to the next
            {
                subSeqLength++;//if it is we increment
                if (subSeqLength > longest)//we assign the longest and new bounds
                {
                    longest = subSeqLength;
                    indexStart = i + 2 - subSeqLength;//make sure the index start is correct. +1 because we incremented len for adding arr[i+1] to the sequence (and then subtracted from i),
                    // +1 because len is not zero based (that is always one larger than i that we also subtracted from i)
                    indexEnd = i + 1; // +1 because our sequence ends at arr[i+1],  or +2??
                }

            } else
                subSeqLength = 1;//else re-initiate the straight length
        }


        int[] ans = new int[longest];
        int cursor = 0;
        for (int i = indexStart; i <= indexEnd; i++) {//print the sequence
            ans[cursor] = arr[i];
            cursor++;
        }

        return ans;
    }

    private static int solve(int reqDistance, int hmin, int hmax, int[] a) {
        int[] dp = new int[a.length]; // dp[i] holds index of last segment the hmin <= length <= hmax

        dp[0] = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] <= hmax && a[i] - a[i - 1] >= hmin) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        // Longest Increasing Continuous Subsequence (lics) with difference 1 in dp[]
        int[] lics = longestIncreasingContSubSq(dp);

        // Sum up length of segments orepresented by lics
        int sum = 0;
        int rightIndex = lics[0];
        for (int i = 1; i < lics.length; i++) {
            sum += (a[lics[i]] - a[lics[i - 1]]);
            if (sum >= reqDistance) {
                // already reached required distance, exit loop.
                rightIndex = lics[i];
                break;
            }
        }


        if (sum == reqDistance) {
            // Got required distance. Return the first value of lics
            return a[lics[0]];
        } else if (sum > reqDistance) {
            int excess = sum - reqDistance;

            // check if we can strip something from right
            int lenRight = a[rightIndex] - a[rightIndex - 1];
            if (lenRight >= excess) {
                return a[lics[0]]; // sequence is ok, return start
            }

            // check if we can strip something from left
            int leftIndex = lics[0];
            int lenLeft = a[leftIndex + 1] - a[leftIndex];
            if (lenLeft >= excess) {
                return leftIndex + excess; // sequence is ok, return start
            }

        } else { // sum < reqDistance
            int missing = reqDistance - sum;

            // check if space left
            if (lics[0] == 0) {
                int leftCoordinate = a[lics[0]];
                // take the missing from minus infinity
                return leftCoordinate - Math.min(hmax, missing);
            } else if (lics[0] > 0) {
                int leftCoordinate = a[lics[0]];
                int lenLeft = a[leftCoordinate] - a[leftCoordinate - 1];
                if (lenLeft >= missing && missing >= hmin && missing <= hmax) {
                    // take missing from left segment
                    return leftCoordinate - Math.min(hmax, missing);
                }
                // lenLeft cannot be >= hmin and <=hmax because then lics[0] would be lics[0]-1
            }


            // Check if space right
            if (lics[lics.length - 1] == a.length - 1) {
                int rightCoordinate = a[lics[lics.length - 1]];
                // take the missing from plus infinity
                return a[lics[0]]; // sequence is ok, return start
            } else if (lics[lics.length - 1] < a.length - 1) {
                int rightCoordinate = a[lics[lics.length - 1]];
                int lenRight = a[rightCoordinate + 1] - a[rightCoordinate];
                if (lenRight >= missing && missing >= hmin && missing <= hmax) {
                    // take missing from right segment
                    return a[lics[0]]; // sequence is ok, return start
                }
                // lenRight cannot be >= hmin and <=hmax because then lics[lics.length-1] would be lics[lics.length-1]+1
            }

        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int speed = 1;
        int distance = in.nextInt();
        int hmin = in.nextInt();
        int hmax = in.nextInt();

        System.out.println(solve(distance, hmin, hmax, a));
    }
}
