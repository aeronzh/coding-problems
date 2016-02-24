package problems;

/**
 * You are situated in an N dimensional grid at position (x1,x2,...,xN). The dimensions of the grid are (D1,D2,...DN)
 * In one step, you can walk one step ahead or behind in any one of the N dimensions. (So there are always 2×N possible different moves).
 * <p/>
 * In how many ways can you take M steps such that you do not leave the grid at any point? You leave the grid if at any point xi, either xi≤0
 * or xi>Di.
 * <p/>
 * Input Format
 * The first line contains the number of test cases T. T test cases follow. For each test case, the first line contains N
 * and M, the second line contains x1,x2,…,xN and the 3rd line contains D1,D2,…,DN.
 * <p/>
 * Output Format
 * Output T lines, one corresponding to each test case. Since the answer can be really huge, output it modulo 1000000007.
 * <p/>
 * Constraints
 * <p/>
 * 1≤T≤10
 * 1≤N≤10
 * 1≤M≤300
 * 1≤Di≤100
 * 1≤xi≤Di
 */
public class GridWalking {

    private static final long MODULO = 1000000007;
    private static long[][] cache;

    private static long[][] solve1d(int n, int m) {
        long[][] dp = new long[n][m + 1];

        // Init dp
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (n == 1) {
            return dp;
        }

        for (int k = 1; k <= m; k++) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp[i][k] = dp[i + 1][k - 1];
                } else if (i == n - 1) {
                    dp[i][k] = dp[i - 1][k - 1];
                } else {
                    dp[i][k] = (dp[i - 1][k - 1] + dp[i + 1][k - 1]) % MODULO;
                }
            }
        }

        return dp;
    }

    private static long[][][] generateDP(int[] dimensions, int m) {
        long[][][] dimensionsDP = new long[dimensions.length][][];
        for (int d = 0; d < dimensions.length; d++) {
            int n = dimensions[d];
            dimensionsDP[d] = solve1d(n, m);
        }

        return dimensionsDP;
    }

    // We do the following:
    // Take m-k steps in dimension i. And k steps in dimensions < i.
    // The number of m-k steps in dimension i can be read from the 1-D Matrix. Let that number be x.
    // The number of k steps in any dimension < i can also be read from the 1-D matrix. Let that number be y.
    // We have to find out in how many ways we can choose k steps out of possible m. This is C(m,k). For example:
    // Let m=3 and k=2. Then we can choose which steps out of m we want to take in a dimension < i: Step1, Step2 or Step1, Step3 or
    // Step2, Step3 = C(m, k) = 3!/(k!*(3-k)!) = 3!/2! = 3
    // So in order to compute in how many ways we can take m-k steps in currentDimension and k steps in a dimension < currentDimension we do:
    // dp[currentDimension][pos[currentDimension]][m - k] * C(m, k) * solve(k, currentDimension - 1)
    // First multiplicator indicates ways in current dimension. For every suche way we have C(m,k) ways to take steps in another dimension, and for
    // every of the C(m,k) ways we can walk solve(k, currentDimension - 1) paths.
    //
    private static long solve(int[] pos, int m, int currentDimension, long[][][] dp) {
        if (currentDimension == 0) {
            return dp[0][pos[0]][m];
        } else {
            long total = 0;

            for (int k = 0; k <= m; k++) {
                long smallerDimensions = cache[currentDimension - 1][k];
                if (smallerDimensions == 0) {
                    smallerDimensions = solve(pos, k, currentDimension - 1, dp) % MODULO;
                    cache[currentDimension - 1][k] = smallerDimensions;
                }

                long cnk = c(m, k, MODULO);
                if ((dp[currentDimension][pos[currentDimension]][m - k] * smallerDimensions * cnk) < 0) {

                }
                total = (total + ((dp[currentDimension][pos[currentDimension]][m - k] * ((smallerDimensions * cnk) % MODULO)) % MODULO)) % MODULO;

            }

            return total;
        }
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

    public static void main(String[] args) {
        int m = 69; //In how many ways can you take M steps such that you do not leave the grid at any point?
        int[] pos = {3, 6, 1, 19, 6};
        for (int p = 0; p < pos.length; p++) {
            pos[p] = pos[p] - 1;
        }

        int[] dimensions = {6, 13, 1, 27, 17};
        long[][][] dp = generateDP(dimensions, m);
        cache = new long[dimensions.length][m + 1];
        long result = solve(pos, m, dimensions.length - 1, dp);
        System.out.println(result);


    }
}
