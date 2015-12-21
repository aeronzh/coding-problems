package exercises.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An array A[1 n] contains all the integers from 0 to n except for one number
 * which is missing. In this problem, we cannot access an entire integer in A
 * with a single operation. The elements of A are represented in binary, and the
 * only operation we can use to access them is "fetch the jth bit of A[i]",
 * which takes constant time. Write code to find the missing integer. Can you do
 * it in O(n) time?
 * 
 * @author lucas
 *
 */
public class E7 {

    private static int bit(int x, int j) {
        return (x>>j) & 1;
    }

    public static String solve(Integer[] array) {
        StringBuilder sb = new StringBuilder();

        int n;
        boolean isEven;
        List<Integer> numbersRemaining = new ArrayList<Integer>();
        List<Integer> evenNumbers = new ArrayList<Integer>();
        List<Integer> oddNumbers = new ArrayList<Integer>();
        numbersRemaining.addAll(Arrays.asList(array));

        do {
            // Count even and odd numbers
            for (Integer number:numbersRemaining) {
                if (bit(number, 0) == 0) {
                    evenNumbers.add(number);
                } else {
                    oddNumbers.add(number);
                }
            }

            n = numbersRemaining.size() + 1;
            if (n % 2 == 0) {
                // n is even
                if (evenNumbers.size() < oddNumbers.size()) {
                    // missing number is even
                    System.out.println("missing number is even");
                    sb.insert(0, "0");
                    isEven = true;
                } else {
                    // missing number is odd
                    System.out.println("missing number is odd");
                    sb.insert(0, "1");
                    isEven = false;
                }
            } else {
                // n is odd
                if (evenNumbers.size() < oddNumbers.size() - 1) {
                    System.out.println("missing number is even");
                    sb.insert(0, "0");
                    isEven = true;
                } else {
                    System.out.println("missing number is odd");
                    sb.insert(0, "1");
                    isEven = false;
                }
            }

            numbersRemaining.clear();
            if (isEven) {
                for (Integer number:evenNumbers) {
                    numbersRemaining.add((number>>1));
                }
            } else {
                for (Integer number:oddNumbers) {
                    numbersRemaining.add((number>>1));
                }
            }

            evenNumbers.clear();
            oddNumbers.clear();
        } while (!numbersRemaining.isEmpty());

        return sb.toString();
    }


	public static void main(String[] args) {
		Integer[] array = {1,3,2,7,8,6,5,10,9}; // 4
        System.out.println(solve(array));

	}

}
