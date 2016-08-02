package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;


public class WoC21_3 {

    private static final int MAX_P = 100;

    private static boolean isSorted(int[] p, int n) {
        for (int i = 1; i < n; i++) {
            if (p[i]<p[i-1]) {
                return false;
            }
        }


        return true;
    }

    /**
     * x^n
     *
     * @param x
     * @param n
     * @return
     */
    public static long pow(long x, long n) {
        long result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * x);
            }

            x = (x * x);
            n = n >> 1;
        }

        return result;
    }

    private static long fact(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }

        return ans;
    }

    /**
     * The number of different permutations of n objects,
     * where there are n1 indistinguishable objects of style 1,
     * n2 indistinguishable objects of style 2, ...,
     * and nk indistinguishable objects of style k, is:
     * <p>
     * n!/(n1! * n2! * ... * nk!)
     *
     * @return Number of unique permutations with repetition
     */
    public static long c(int[] p, int n) {
        long ans = 1;

        long numerator = fact(n);

        int[] count = new int[MAX_P + 1];
        for (int i = 0; i < n; i++) {
            count[p[i]] = count[p[i]] + 1;
        }

        long denominator = 1;

        for (int i = 1; i <= MAX_P; i++) {
            denominator = denominator * fact(count[i]);
        }

        ans = numerator / denominator;

        return ans;
    }

    private static double solve(int[] p, int n) {
        if (isSorted(p,n)) {
            return 0.0;
        }


        double totalUnique = c(p, n);

        int[] count = new int[MAX_P + 1];
        for (int i = 0; i < n; i++) {
            count[p[i]] = count[p[i]] + 1;
        }

        double repeat = 1;
        for (int i = 1; i <= MAX_P; i++) {
            repeat = repeat * fact(count[i]);
        }

        // Probability of each individual permutation
        double prob = repeat / totalUnique;


        // Expected value = Sum_i_inf (i*prob)^i
        double sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += (i * Math.pow(prob, i));
        }

        return Math.round(sum * 1000000D) / 1000000D;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }


        System.out.printf("%.6f", solve(p, n));
    }
}
