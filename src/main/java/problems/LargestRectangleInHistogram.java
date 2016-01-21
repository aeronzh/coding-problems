package problems;

import java.util.Stack;

/**
 * 
 LeetCode Largest Rectangle in Histogram (Java)
 * 
 * 
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * For example, given height = [2,1,5,6,2,3], return 10.
 * 
 * http://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-
 * java/
 * 
 * @author lucas
 *
 */

//       #
//     # #
//     # #
//     # #   #
// #   # # # #
// # # # # # #

// largest are is marked with 'x' --->

//       #
//     x x
//     x x
//     x x   #
// #   x x # #
// # # x x # #
public class LargestRectangleInHistogram {

	private static void print(int[] array, int start, int end, int height) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] >= (max - i)) {
					if (j >= start && j <= end && max-i <= height) {
						System.out.print("x");
					} else {
						System.out.print("#");
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static int solve(int[] height) {
		int start = 0;
		int end = 0;
		int areaHeight = height[0];
		int maxArea = height[0];

		for (int i = 0; i < height.length; i++) {
			int minHeight = height[i];
			for (int j = i; j < height.length; j++) {
				minHeight = Math.min(minHeight, height[j]);
				int area = (j - i + 1) * minHeight;
				if (area > maxArea) {
					maxArea = area;
					areaHeight = minHeight;
					start = i;
					end = j;
				}
			}
		}

		print(height, start, end, areaHeight);
		return maxArea;
	}

	
	// O(n)
	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
	 
		Stack<Integer> stack = new Stack<Integer>();
	 
		int max = 0;
		int i = 0;
	 
		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
	 
		}
	 
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	 
		return max;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] { 2, 1, 5, 6, 2, 3 };
		System.out.println("area=" + solve(array));
		
		System.out.println(largestRectangleArea(array));
	}

}
