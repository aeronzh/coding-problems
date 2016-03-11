package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Borussia Dortmund are a famous football ( soccer ) club from Germany. Apart
 * from their fast-paced style of playing, the thing that makes them unique is
 * the hard to pronounce names of their players ( błaszczykowski ,
 * papastathopoulos , großkreutz etc. ).
 * <p/>
 * The team's coach is your friend. He is in a dilemma as he can't decide how to
 * make it easier to call the players by name, during practice sessions. So, you
 * advise him to assign easy names to his players. A name is easy to him if
 * <p/>
 * 1. It consists of only one word.
 * <p/>
 * 2. It consists of only lowercase english letters.
 * <p/>
 * 3. Its length is exactly N.
 * <p/>
 * 4. It contains exactly K different letters from the 26 letters of English
 * alphabet.
 * <p/>
 * 5. At least one of its proper prefixes matches with its proper suffix of same
 * length.
 * <p/>
 * Given, N and K you have to tell him the number of easy names he can choose
 * from modulo (10^9+9).
 * <p/>
 * Note : A prefix P of a name W is proper if, P≠W. Similarly, a suffix S of a
 * name W is proper if, S≠W.
 * <p/>
 * Input Format The first line of the input will contain T ( the number of
 * testcases ). Each of the next T lines will contain 2 space separated integers
 * N and K.
 * <p/>
 * Output Format For each testcase, output the number of ways the coach can
 * assign names to his players modulo (10^9+9).
 * <p/>
 * Constraints
 * <p/>
 * 1≤T≤10^5
 * <p/>
 * 1≤N≤10^5
 * <p/>
 * 1≤K≤26
 * <p/>
 * <p/>
 * Sample Input #1
 * <p/>
 * 3
 * <p/>
 * 1 1
 * <p/>
 * 2 1
 * <p/>
 * 4 2
 * <p/>
 * <p/>
 * Sample Output #1
 * <p/>
 * 0
 * <p/>
 * 26
 * <p/>
 * 2600
 *
 * @author lucas
 */
public class DortmundDilemma {
    private static final long MODULO = 1000000009;
    private static final int ALPHABET_SIZE = 26;

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

    /**
     * Let k =2 and n=6
     * <p/>
     * Strings starting with a or b:
     * <p/>
     * a _ _ _ _ a | b _ _ _ _ b  ==> 2 * (k^(n - 2*1)) - k
     * <p/>
     * <p/>
     * Strings starting with ab or ba:
     * <p/>
     * ab _ _ ab | ba _ _ ba ==> 2 * (k^(n - 2*2))
     * <p/>
     * <p/>
     * String starting with aab, aba, baa, abb, bab, bba:
     * <p/>
     * ==> 6 * (k^(n - 2*3))
     *
     * @param n
     * @param k
     */
    private static long solve(int n, int k) {
        // Case a, b, ... etc
        long sum = 0;
        if (k > 1) {
            sum = k * (pow(k, (n - 2), MODULO)) - k;
        } else if (k == 1 && n>1) {
            return ALPHABET_SIZE;
        }


        for (int fixLen = 2; fixLen <= n / 2; fixLen++) {
            long numOfFixes = pow(k, fixLen, MODULO) - k;

            sum = sum + numOfFixes * (pow(k, (n - 2 * fixLen), MODULO));
        }

        // BUG: We are counting some words twice. For example:
        // a _ _ _ _ _ a and aba _ aba

        long cnk = c(ALPHABET_SIZE, k, MODULO);

        return (cnk * sum);
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {

            int n = scanner.nextInt();
            int k = scanner.nextInt();
            long result = solve(n, k);

            long expectedResult = outputScanner.nextLong();

            if (result != expectedResult) {
                System.out.println("got= " + result + "    expected= " + expectedResult + "  input= " + n + " " + k);
            }
        }

    }

}
