package com.lucaslouca.other;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value. You are giving candies to these children subjected to the following
 * requirements:
 * 
 * 1. Each child must have at least one candy.
 * 
 * 2. Children with a higher rating get more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * @author lucas
 *
 */
public class Candy {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static int[] candy(int[] rating) {
		int len = rating.length;
		int[] candy = new int[len];

		candy[0] = 1;
		for (int i = 1; i < len; i++) {

			if (rating[i] < rating[i - 1]) {
				candy[i] = 1;
				int t0 = i - 1;
				int t1 = i;
				while (t0 >= 0 && candy[t0] <= candy[t1] && rating[t1] <= rating[t0]) {
					candy[t0] = candy[t0] + 1;
					t1 = t0;
					t0--;
				}
			}

			if (rating[i] > rating[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}

			if (rating[i] == rating[i - 1]) {
				candy[i] = candy[i - 1];
			}
		}

		return candy;

	}

	public static int getcandy(int[] ratings) {

		int[] candies = new int[ratings.length];

		candies[0] = 1;

		//from left to right

		for (int i = 1; i < ratings.length; i++) {

			if (ratings[i] > ratings[i - 1])

				candies[i] = candies[i - 1] + 1;

			else

				candies[i] = 1;

		}

		int result = candies[ratings.length - 1];

		//from right to left
		print(candies);

		for (int i = ratings.length - 2; i >= 0; i--) {

			int curr = 1;

			if (ratings[i] > ratings[i + 1])

				curr = candies[i + 1] + 1;

			// consider same rating neighbors with different candies

			else if (ratings[i] == ratings[i + 1] && candies[i] < candies[i + 1])

				curr = candies[i + 1];

			candies[i] = Math.max(curr, candies[i]);

			result += candies[i];

		}

		print(candies);
		return result;

	}

	private static int sum(int[] candy) {
		int sum = 0;
		for (int i = 0; i < candy.length; i++) {
			sum += candy[i];
		}

		return sum;
	}

	// Children: 3 2 3 4 2 1 5 5 2 1 2 3 4 3
	//           1 1 2 3 1 1 2 1 1 1 2 3 4 1
	//                                 3 4 1  
	public static void main(String[] args) {
		int[] children = { 1, 2, 3, 2, 1, 3, 1 };
		int[] candy = candy(children);

		getcandy(children);
	}

}
