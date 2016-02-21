package problems;

/**
 * Your algorithms have become so good at predicting the market that you now know what the share price of
 * Wooden Orange Toothpicks Inc. (WOT) will be for the next N days.
 * <p/>
 * Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own,
 * or not make any transaction at all. What is the maximum profit you can obtain with an optimum trading strategy?
 */
public class StockPrices {
    public static void main(String[] args) {
        long price[] = {1, 3, 1, 2};
        int n = price.length;
        long[] max = new long[n];
        long tmpMax = price[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (price[i] >= tmpMax) {
                tmpMax = price[i];
                max[i] = tmpMax;
            } else {
                max[i] = tmpMax;
            }
        }


        long income = 0;
        long amount = 0;

        for (int i = 0; i < n; i++) {
            if (i < n - 1 && price[i] < max[i + 1]) {
                // buy
                amount++;
                income -= price[i];
            } else if (i < n - 1 && price[i] > max[i + 1] && amount > 0) {
                // sell
                income += (amount * price[i]);
                amount = 0;
            } else if (i == n - 1 && amount > 0) {
                // sell
                income += (amount * price[i]);
            }
        }

        System.out.println(income);


    }
}
