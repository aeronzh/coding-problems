package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lucas on 05/12/2016.
 */
public class LongestIncreasingContinuousSubsequence {
    // Longest Increasing Continuous Subsequence with difference 1 (e.g. 1,2,3 but not 1,2,4)
    public static int[] longestIncreasingContSubSq(int[] arr) {
        int subSeqLength = 1;
        int longest = 1;
        int indexStart = 0;
        int indexEnd = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1])//We need to check if the current is equal to the next
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

    public static void main(String[] args) {
        int[] a = {3, 4, 1, 2, 3, 3, 4, 5, 10, 99, 100, 80};

        int[] seq = longestIncreasingContSubSq(a);

        for (int i : seq) {
            System.out.print(i + " ");
        }
    }
}
