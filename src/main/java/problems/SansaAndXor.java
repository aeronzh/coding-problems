package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lucas on 13/02/2017.
 */
public class SansaAndXor {
    private static int solve(int[] a) {
        int n = a.length;

        if (n % 2 == 0) {
            return 0;
        }

        int ans = a[0];
        for (int i = 2; i < n; i += 2) {
            ans ^= a[i];
        }

        return ans;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int tests = in.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            System.out.println(solve(a));
        }
    }
}
