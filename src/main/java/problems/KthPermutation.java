package problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthPermutation {

    static long[] factCache;

    private static long factorial(int n) {
        if (factCache[n] != 0) {
            return factCache[n];
        }
        long result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }

        factCache[n] = result;
        return result;
    }

    public static List<Integer> ithpermutation(int n, long k) {
        List<Integer> permutation = new ArrayList<Integer>();

        List<Integer> symbols = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            symbols.add(i);
        }

        long fact = factorial(n - 1);
        int i;
        while (n > 0) {
            i = (int) (k / fact);
            permutation.add(symbols.get(i));
            symbols.remove(i);
            k = k % fact; // Rest
            fact /= Math.max(1, (n - 1)); // (n-1)!, (n-2)!, (n-3)!, ...
            n--;
        }

        return permutation;
    }

    public static int dist(int[] permutation) {
        int min = Integer.MAX_VALUE;
        if (permutation.length == 1) {
            return 1;
        }

        for (int j = 0; j < permutation.length - 1; j++) {
            min = Math.min(min, Math.abs(permutation[j] - permutation[j + 1]));
        }

        return min;
    }


    public static void print(int[] permutation) {
        StringBuilder sb = new StringBuilder();
        for (int number : permutation) {
            sb.append(number + " ");
        }
        System.out.println(sb.substring(0, sb.length()));
    }

    public static int[] maxPerm(int n) {
        List<Integer> maxPerm = new ArrayList<Integer>();
        boolean smallLeft = true;
        for (int i = 0; i < Math.ceil((double) n / 2.0); i++) {
            if (smallLeft) {
                maxPerm.add(0, n - i);
                if (maxPerm.size() < n) {
                    maxPerm.add(0, i + 1);
                    smallLeft = false;
                }
            } else {
                maxPerm.add(i + 1);
                if (maxPerm.size() < n) {
                    if (maxPerm.size() == n - 1 && n % 2 == 0) {
                        maxPerm.add(0, n - i);
                    } else {
                        maxPerm.add(n - i);
                    }
                    smallLeft = true;
                }
            }
        }

        int[] perm = new int[n];
        if (maxPerm.get(0) > maxPerm.get(n - 1)) {
            // Reverse
            for (int i = n - 1; i >= 0; i--) {
                perm[n - i - 1] = maxPerm.get(i);
            }
        } else {
            for (int i = 0; i < n; i++) {
                perm[i] = maxPerm.get(i);
            }
        }

        return perm;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static boolean next(int n, int[] perm, int maxDist) {
        int i = n - 1;

        // Loop from right to left until we find a value that is smaller than its right neighbor.
        while (perm[i - 1] >= perm[i]) {
            i--;
            if (i<=0) {
                return false;
            }
        }


        // 5 1 4 3 0

        int j = n - 1;

        // Loop from right to left until we find a value that is larger than perm[i-1]
        // That is, find the next smallest element that is larger than perm[i-1]. Remember all elements to the right
        // of perm[i] are smaller than perm[i]
        while (perm[j] <= perm[i - 1]) {
            j--;
        }

        // Swap perm[i-1] with perm[j-1]
        swap(perm, i - 1, j);


        // Bubble the perm[i] element up to the right
        j = n - 1;
        while (i < j) {
            swap(perm, i, j);
            i++;
            j--;
        }

        return true;
    }

    public static void solve(int n, long k) {
        int[] currentPerm = maxPerm(n);
        int maxDist = dist(currentPerm);

        for (int i=0; i<n; i++) {
            currentPerm[i] = i+1;
        }

        int count = 0;
        boolean result = true;
        while (count < k && result==true) {
            if(dist(currentPerm) == maxDist) {
                count++;
            }
            if (count == k) {
                break;
            }
            result = next(n, currentPerm, maxDist);
        }

        if (count <k) {
            System.out.println(-1);
        } else {
            print(currentPerm);
        }
    }

    public static void main(String[] args) {
        factCache = new long[1];

        int n = 4;
        long k = 2;


        if (n > factCache.length - 1) {
            long[] tmp = new long[n + 1];
            System.arraycopy(factCache, 0, tmp, 0, factCache.length);
            factCache = tmp;
        }

        solve(n, k);
    }

}
