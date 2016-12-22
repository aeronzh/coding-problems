package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WoC24_3 {
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

                // i*2, i*3, i*4,...,k
                for (int j=i*i; j<=k; j=j+i) {
                    a[j] = false;
                }

                // The smallest integer x such that xi >= n is x=⌈n/i⌉ or x=(n+i-1)/i)
                // what if n=9 and i = 2? then ⌈9/2⌉ = 5 and 5*2 = 10. Why is it ok to skip 9?
                // --> we will cross it off later when i=3
                for (int j=Math.max(2, (int)Math.ceil( (double)n/(double)i ))*i; j<=m; j=j+i) {
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
        System.out.println(Math.floor(-1.5));
        System.out.println(-3/2);
    }
}
