package problems;

/**
 * Created by lucas on 21/02/16.
 */
public class ExponentiationBySquaring {

    // Example:
    // 15 = b1101
    // x^15 = x^(2^3) * x(2^2) * x^(2^0)
    // x^15 = x^8 * x^4 * x^1
    public static int pow(int x, int n)
    {
        int result = 1;
        while (n > 0)
        {
            if ((n & 1) == 1) {
                // Multiply with the current power of two
                result = result * x;
            }

            
            n >>= 1;

            // Get the next x to the power of 2
            x = x * x; // x^2, x^4, x^8, x^16, ....
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(pow(3,5));
    }
}
