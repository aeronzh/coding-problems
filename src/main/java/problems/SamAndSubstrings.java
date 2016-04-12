package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by lucas on 12/04/16.
 */
public class SamAndSubstrings {
    private static final long MODULO = 1000000007;

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    public static long pow(long x, long n, long p) {
        long result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * x) % p;
            }

            x = (x * x) % p;
            n = n >> 1;
        }

        return result;
    }

    public static long c(int n, int k, long p) {
        // C(n,k) = n!/(k!*(n-k)!)

        long numerator = 1;
        for (int i = 0; i < k; i++) {
            numerator = (numerator * (n - i)) % p;
        }

        long denominator = 1;
        for (int i = 1; i <= k; i++) {
            denominator = (denominator * i) % p;
        }

        return (numerator * (pow(denominator, p - 2, p))) % p;
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

        Scanner scanner = new Scanner(System.in);

        String line = scanner.next();
        char[] splitted = line.toCharArray();
        int[] a = new int[splitted.length];
        for (int i=0; i<splitted.length; i++) {
            a[i] = splitted[i]-48;
        }

        print(a);
    }
}
