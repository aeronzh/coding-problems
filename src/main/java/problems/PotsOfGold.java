package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lucas on 25/12/2016.
 */
public class PotsOfGold {
    private static int choose(int[] pots, int start, int end) {
        if (start > end) {
            return 0;
        }

        int chooseFromStart = pots[start] + Math.min(choose(pots, start + 2, end), choose(pots, start + 1, end - 1));

        int chooseFromEnd = pots[end] + Math.min(choose(pots, start + 1, end - 1), choose(pots, start, end - 2));

        // Now return the maximum of the two choices.
        return Math.max(chooseFromStart, chooseFromEnd);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] pots = new int[n];
        for (int i=0; i<n; i++) {
            pots[i] = scanner.nextInt();
        }

        int result = choose(pots, 0, pots.length - 1);
        System.out.println(result);
    }
}
