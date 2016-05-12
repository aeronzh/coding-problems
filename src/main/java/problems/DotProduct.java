package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given two sparse Vectors, compute the Dot Product.
 * Input Format : The first line will contain two numbers(k and n), which are the number of entries for the two vectors respectively.
 * The next k lines are the entries for the first vector, of the form : x y
 * where x is the position and y is the value at that position in the vector.
 * The n lines are the entries of the second vector.
 * Any entries not specified indicate zero at that position.
 * The two vectors will always be of the same length
 * <p/>
 * Example input:
 * <p/>
 * 3 3
 * <p/>
 * 1 4
 * <p/>
 * 4 2
 * <p/>
 * 5 3
 * <p/>
 * 1 7
 * <p/>
 * 2 6
 * <p/>
 * 5 1
 * <p/>
 * Sample Answer: Dot Product = 4*7+3*1 = 31 (only print 31)
 */
public class DotProduct {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        Map<Integer,Integer> a = new HashMap<Integer,Integer>();
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            a.put(x,y);
        }


        Map<Integer,Integer> b = new HashMap<Integer,Integer>();
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            b.put(x,y);
        }

        int product = 0;
        for (Integer x:a.keySet()) {
            if (b.containsKey(x)) {
                product +=(a.get(x)*b.get(x));
            }
        }

        System.out.println(product);

    }
}
