package problems;

/**
 * Write a program that takes an array denoting the daily stock price, and returns the maximum profit that could be
 * made by buying and then selling one share of stock.
 * 
 * @author lucas
 *
 */
public class BuySellStockOnce {

	public static int solve(int[] stockPrice) {
		int minimumSeenSoFar = stockPrice[0];
		int[] maxProfit = new int[stockPrice.length];
		
		for (int i=0; i<stockPrice.length; i++) {
			maxProfit[i] = stockPrice[i] - minimumSeenSoFar;
			
			if (stockPrice[i] < minimumSeenSoFar) {
				minimumSeenSoFar = stockPrice[i];
			}
		}
		
		int max = maxProfit[0];
		for (int i=0; i<maxProfit.length; i++) {
			if (max < maxProfit[i]) {
				max = maxProfit[i];
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		int[] stocks = { 310, 315, 275, 295, 260, 270, 290, 230, 255, 250 };

		System.out.println(solve(stocks));
		
	}

}
