package problems;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by lucas on 25/12/2016.
 */
public class GenerateTestsForCelebrityProblem {

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void main(String[] args) {
        int n = 19999;
        int celebrity = randInt(1, n);

        Set<String> ans = new HashSet<String>();
        int k = 0;
        for (int i = 1; i <= n; i++) {

            // i knows celebrity
            if (i != celebrity) {
                ans.add(i + " " + celebrity);
                k++;


                // i know at most 100 other people other than himself or celebrity
                int knows = randInt(1, 5);
                for (int j = 0; j < knows; j++) {
                    int other;
                    do {
                        other = randInt(1, n);
                    } while (other == i || other == celebrity || ans.contains(i + " " + other));

                    ans.add(i + " " + other);
                    k++;
                }
            }
        }

        System.out.println("celebrity= " + celebrity);

        try {
            PrintWriter writer = new PrintWriter(System.getProperty("user.home") + "/" + "in.txt", "UTF-8");
            writer.println(n + " " + k);
            for (String row : ans) {
                writer.println(row);
            }
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }
}
