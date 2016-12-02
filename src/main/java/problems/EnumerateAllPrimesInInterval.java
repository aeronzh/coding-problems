package problems;

import java.util.HashSet;
import java.util.Set;

public class EnumerateAllPrimesInInterval {
    // Sieve of Eratosthenes for [n,m]
    public static Set<Integer> primes(int n, int m) {
        Set<Integer> primes = new HashSet<Integer>();

        int k = (int)Math.sqrt(m);
        boolean[] a = new boolean[k+1];
        boolean[] b = new boolean[m-n+1];

        for (int i=0; i<a.length; i++) {
            a[i] = true;
        }

        for (int i=0; i<b.length; i++) {
            b[i] = true;
        }

        for (int i=2; i<=k; i++) {
            if (a[i]) {

                // Cross off i^2, i^2+i, i^2+i*2, i^2+i*3, i^2+i*4,...,k
                for (int j=i*i; j<=k; j=j+i) {
                    a[j] = false;
                }

                // Cross off i^2, i^2+i, i^2+i*2, i^2+i*3, i^2+i*4,... in [n,m]
                for (int j=Math.max(2, (n + i - 1)/i)*i; j<=m; j=j+i) {
                    b[j - n] = false;
                }
            }
        }


        for (int i=0; i<b.length; i++) {
            if (b[i]) {
                primes.add(i+n);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 13;
        Set<Integer> primes = primes(n, m);
        System.out.println(primes);
    }
}
