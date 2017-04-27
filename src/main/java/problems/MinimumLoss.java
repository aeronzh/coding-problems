package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 Lauren has a chart of distinct projected prices for a house over the next
 * $latex n$ years, where the price of the house in the $latex i^{th}$ year is
 * $latex p_i$. She wants to purchase and resell the house at a minimal loss
 * according to the following rules:
 * 
 * The house cannot be sold at a price greater than or equal to the price it was
 * purchased at (i.e., it must be resold at a loss). The house cannot be resold
 * within the same year it was purchased. Find and print the minimum amount of
 * money Lauren must lose if she buys the house and resells it within the next
 * years.
 * 
 * Note: It's guaranteed that a valid answer exists.
 * 
 ** Input Format**
 * 
 * The first line contains an integer, $latex n$, denoting the number of years
 * of house data. The second line contains space-separated long integers
 * describing the respective values of $latex p_1, p_2,\dots, p_n$.
 * 
 ** Constraints** $latex 2\le n \le 2 \times 10^5$ $latex 1 \le p_i \le 10^{16}$
 * All the prices are distinct. It's guaranteed that a valid answer exists.
 * 
 ** Output Format**
 * 
 * Print a single integer denoting the minimum amount of money Lauren must lose
 * if she buys and resells the house within the next $latex n$ years.
 * 
 ** Sample Input 0** ``` 3 5 10 3 ```
 * 
 ** Sample Output 0** ``` 2 ```
 * 
 ** Explanation 0**
 * 
 * Lauren buys the house in year $latex 1$ at price $latex p_1 = 5$ and sells it
 * in year $latex 3$ at $latex p_3 = 3$ for a minimal loss of $latex 5 - 3 = 2$.
 * 
 ** Sample Input 1** ``` 5 20 7 8 2 5 ```
 * 
 ** Sample Output 1** ``` 2 ```
 * 
 ** Explanation 1**
 * 
 * Lauren buys the house in year $latex 2$ at price $latex p_2 = 7$ and sells it
 * in year $latex 5$ at $latex p_5 = 5$ for a minimal loss of $latex 7 - 5 = 2$.
 * 
 *
 */
public class MinimumLoss {

	private static class MyBinaryTreeNode {
		long value;
		MyBinaryTreeNode left = null;
		MyBinaryTreeNode right = null;
		MyBinaryTreeNode parent = null;

		public MyBinaryTreeNode(long value) {
			this.value = value;
		}

		public MyBinaryTreeNode add(long newValue) {
			if (newValue <= this.value) {
				if (this.left == null) {
					this.left = new MyBinaryTreeNode(newValue);
					this.left.parent = this;
					return this.left;
				} else {
					// Go left
					return this.left.add(newValue);
				}
			} else {
				if (this.right == null) {
					this.right = new MyBinaryTreeNode(newValue);
					this.right.parent = this;
					return this.right;
				} else {
					// Go right
					return this.right.add(newValue);
				}
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.value);
			sb.append("->[");
			if (this.left != null) {
				sb.append(this.left.toString());
			} else {
				sb.append(".");
			}

			sb.append(",");

			if (this.right != null) {
				sb.append(this.right.toString());
			} else {
				sb.append(".");
			}
			sb.append("]");
			return sb.toString();
		}

		public long traverseUp() {
			if (this.parent != null) {
				if (this.parent.left != null) {
					if (!this.parent.left.equals(this)) {
						// Parent has a left child, but its not the current node --> go up
						return this.parent.traverseUp();
					} else {
						// Parent has left child and its the current node --> return parent's value
						return this.parent.value;
					}
				} else {
					// Parent has no left child --> current node must be right child, so we go up
					return this.parent.traverseUp();
				}
			} else {
				// No parent
				return -1;
			}
		}

	}

	private static long solve(long[] p, int n) {
		// Build Binary Search Tree and store the nodes into a LinkedList = (O(nlogn)
		MyBinaryTreeNode root = new MyBinaryTreeNode(p[0]);
		List<MyBinaryTreeNode> nodes = new LinkedList<MyBinaryTreeNode>();
		nodes.add(root);
		for (int i = 1; i < n; i++) {
			nodes.add(root.add(p[i]));
		}

		// Go through all the nodes x in the BST and for each node go up until the current node i is the left child of its parent. if 
		// the current node i is a left child then return the value of its parent. This value is the smallest value that is greater than the value
		// of the original/starting node x.
		long minLoss = Long.MAX_VALUE;
		for (MyBinaryTreeNode node : nodes) {
			long minLarger = node.traverseUp();
			if (minLarger >= 0) {
				minLoss = Math.min(minLoss, minLarger - node.value);
			}
		}

		return minLoss;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		long[] p = new long[n];
		for (int i = 0; i < n; i++) {
			p[i] = in.nextLong();
		}

		System.out.println(solve(p, n));
	}
}
