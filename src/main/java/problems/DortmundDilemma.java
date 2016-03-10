package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Borussia Dortmund are a famous football ( soccer ) club from Germany. Apart
 * from their fast-paced style of playing, the thing that makes them unique is
 * the hard to pronounce names of their players ( błaszczykowski ,
 * papastathopoulos , großkreutz etc. ).
 * 
 * The team's coach is your friend. He is in a dilemma as he can't decide how to
 * make it easier to call the players by name, during practice sessions. So, you
 * advise him to assign easy names to his players. A name is easy to him if
 * 
 * 1. It consists of only one word.
 * 
 * 2. It consists of only lowercase english letters.
 * 
 * 3. Its length is exactly N.
 * 
 * 4. It contains exactly K different letters from the 26 letters of English
 * alphabet.
 * 
 * 5. At least one of its proper prefixes matches with its proper suffix of same
 * length.
 * 
 * Given, N and K you have to tell him the number of easy names he can choose
 * from modulo (10^9+9).
 * 
 * Note : A prefix P of a name W is proper if, P≠W. Similarly, a suffix S of a
 * name W is proper if, S≠W.
 * 
 * Input Format The first line of the input will contain T ( the number of
 * testcases ). Each of the next T lines will contain 2 space separated integers
 * N and K.
 * 
 * Output Format For each testcase, output the number of ways the coach can
 * assign names to his players modulo (10^9+9).
 * 
 * Constraints
 * 
 * 1≤T≤10^5
 * 
 * 1≤N≤10^5
 * 
 * 1≤K≤26
 * 
 * 
 * Sample Input #1
 * 
 * 3
 * 
 * 1 1
 * 
 * 2 1
 * 
 * 4 2
 * 
 * 
 * Sample Output #1
 * 
 * 0
 * 
 * 26
 * 
 * 2600
 * 
 * @author lucas
 *
 */
public class DortmundDilemma {
	private static final long MODULO = 1000000009;

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

		int tests = scanner.nextInt();

		
		System.out.println("c(26,2) = "+c(26,2,MODULO));
		for (int t = 0; t < tests; t++) {

			int n = scanner.nextInt();
			int k = scanner.nextInt();
			long result = 0;

			long expectedResult = outputScanner.nextLong();

			if (result != expectedResult) {
				System.out.println("got= " + result + "    expected= " + expectedResult + "  input= " + n + " " + k);
			}
		}

	}

}
