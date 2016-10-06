package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Alex is preparing for a programming contest and decides the gears turning in his head are at war with his own laziness.
 * He imagines chains of n circularly linked gears trying to turn in his head, and wonders under which circumstances they
 * might be able to turn together in a single chain and when they might be locked (i.e., unable to rotate together).
 * <p>
 * Alex decides to set a problem for himself by creating q queries where each query takes the form of an integer, n,
 * denoting some number of circularly linked gears. For each query, print Yes on a new line if the gears can turn together; otherwise, print No.
 */
public class WoC_23_1 {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int queries = in.nextInt();
        for (int q=0; q<queries; q++) {
            int n = in.nextInt();
            if (n%2 == 1) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
