package problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/contests/w26/challenges/twins
 */
public class Twins {
    // Sieve of Eratosthenes for [n,m]
    public static Set<Integer> primes(int n, int m) {
        Set<Integer> primes = new TreeSet<>();

        int k = (int) Math.sqrt(m);
        boolean[] a = new boolean[k + 1];
        boolean[] b = new boolean[m - n + 1];

        for (int i = 0; i < a.length; i++) {
            a[i] = true;
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = true;
        }

        for (int i = 2; i <= k; i++) {
            if (a[i]) {
                for (int j = i * i; j <= k; j = j + i) {
                    a[j] = false;
                }

                for (int j = Math.max(2, (n + i - 1) / i) * i; j <= m; j = j + i) {
                    b[j - n] = false;
                }
            }
        }


        for (int i = 0; i < b.length; i++) {
            if (b[i] && (i + n) > 1) {
                primes.add(i + n);
            }
        }
        return primes;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> primes = primes(n, m);
        int count = 0;
        for (int prime : primes) {
            if (primes.contains(prime + 2)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
