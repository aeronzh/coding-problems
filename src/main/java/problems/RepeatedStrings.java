package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
 * <p>
 * Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.
 */
public class RepeatedStrings {

    private static void solve(String s, long n) {
        int[] count = new int[s.length()]; // count[i] holds the number of 'a' until index i

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (i > 0) {
                    count[i] = count[i - 1] + 1;
                } else {
                    count[i] = 1;
                }
            } else {
                if (i > 0) {
                    count[i] = count[i - 1];
                }
            }
        }

        long total = 0;

        if (n>=s.length()) {
            long wholeWords = (n / s.length());
            total = wholeWords * count[s.length() - 1];

            int remain = (int)(n - (wholeWords * s.length()));
            if (remain > 0) {
                total += count[remain-1];
            }
        } else {
            total = count[(int)(n-1)];
        }

        System.out.println(total);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        String s = in.next();
        long n = in.nextLong();
        solve(s,n);
    }
}
