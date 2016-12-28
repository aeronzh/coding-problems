package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/hackerland-radio-transmitters
 */
public class RadioTransmitters {
    private static int solve(int[] x, int k) {
        int ans = 0;
        Arrays.sort(x);

        int n = x.length;
        int last = 0;
        int i = 0;
        while (i < x.length) {
            while (i < n && x[i] <= x[last] + k) {
                i++;
            }

            ans++;
            last = i - 1;

            while (i < n && x[i] <= x[last] + k) {
                i++;
            }
            last = i;
        }


        return ans;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }

        System.out.println(solve(x, k));
    }
}
