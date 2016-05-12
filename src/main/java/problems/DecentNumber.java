package problems;

import java.util.Arrays;

/**
 * Created by lucas on 14/02/16.
 */
public class DecentNumber {
    public static void main(String[] args) {
            int n = 4;

            int numberOfThrees = 0;
            String fivesStr = "";
            String threesStr = "";
            for (int numberOfFives=n; numberOfFives>=0; numberOfFives--) {
                numberOfThrees = n - numberOfFives;
                if (numberOfThrees % 5 == 0 && numberOfFives % 3 == 0) {
                    // Consider a number with numberOfFives 5s and numberOfFives 3s
                    char[] fives = new char[numberOfFives];
                    Arrays.fill(fives, '5');
                    fivesStr = new String(fives);

                    char[] threes = new char[numberOfThrees];
                    Arrays.fill(threes, '3');
                    threesStr = new String(threes);

                    break;
                }
            }

            if ("".equals(fivesStr) && "".equals(threesStr)) {
                System.out.println("-1");
            } else {
                System.out.println(fivesStr+threesStr);
            }
    }
}
