package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Little Priyanka visited a kids' shop. There are  toys and their weight is represented by an array . Each toy costs 1 unit, and if she buys a toy with weight , then she can get all other toys whose weight lies between   (both inclusive) free of cost.
 * <p/>
 * Input Format
 * <p/>
 * The first line contains an integer  i.e. number of toys.
 * <p/>
 * Next line will contain  integers, , representing the weight array.
 * <p/>
 * Output Format
 * <p/>
 * Minimum units with which Priyanka could buy all of toys.
 * <p/>
 * Constraints
 * <p/>
 * <p/>
 * <p/>
 * Sample Input
 * <p/>
 * 5
 * <p/>
 * 1 2 3 17 10
 * <p/>
 * <p/>
 * Sample Output
 * <p/>
 * 3
 * <p/>
 * <p/>
 * Explanation
 * <p/>
 * She buys  toy with weight  for  unit and gets  and  toy for free since their weight lies between . And she has to buy last two toys separately.
 */
public class PriyankaAndToys {


    private static int solve(int[] w) {
        Arrays.sort(w);

        int n = w.length;
        int index = 0;
        int count = 0;

        int prev = w[index++];
        count++;

        while (index < n) {
            if (w[index] <= prev + 4) {
                index++;
            } else {
                prev = w[index];
                count++;
                index++;
            }
        }


        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }

        System.out.println(solve(w));
    }
}
