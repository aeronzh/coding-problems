package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;


public class AngryChildren2 {
    private static BigInteger solve(int[] a, int n, int k) {
        Arrays.sort(a);

        // Compute prefix sum
        BigInteger[] prefixSum = new BigInteger[n];
        prefixSum[0] = new BigInteger("" + a[0]);
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1].add(new BigInteger("" + a[i]));
        }


        BigInteger d = BigInteger.ZERO;
        BigInteger ans = new BigInteger("" + Long.MAX_VALUE);
        for (int i = 1; i < n; i++) {
            if (i < k) {
                d = d.add(new BigInteger("" + i).multiply(new BigInteger("" + a[i]))).subtract(prefixSum[i - 1]);
                ans = d;
            } else {
                BigInteger x = prefixSum[i - 1].subtract(prefixSum[i - k]).subtract((new BigInteger("" + (k - 1))).multiply(new BigInteger("" + a[i - k])));
                BigInteger y = (new BigInteger("" + (k - 1))).multiply(new BigInteger("" + a[i])).subtract(prefixSum[i - 1].subtract(prefixSum[i - k]));
                BigInteger res = d.subtract(x).add(y);
                if (res.compareTo(BigInteger.ZERO) > 0) {
                    if (d.compareTo(ans) < 0) {
                        ans = d;
                    }
                    d = res;
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(solve(a, n, k));
    }
}
