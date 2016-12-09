package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The
 * Next greater Element for an element x is the first greater element on the
 * right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1.
 * 
 * @author lucas
 *
 */
public class NextGreaterElement {
	private static class BinaryTreeNode {
		private BinaryTreeNode parent;
		private Integer data;

		private BinaryTreeNode left;
		private BinaryTreeNode right;

		public BinaryTreeNode(Integer data) {
			this.data = data;
		}

		public void addNode(BinaryTreeNode node) {
			node.parent = this;
			if (node.data <= this.data) {
				// go left
				if (this.left == null) {
					this.left = node;
				} else {
					this.left.addNode(node);
				}
			} else {
				if (this.right == null) {
					this.right = node;
				} else {
					this.right.addNode(node);
				}
			}
		}
	}

	// 4, 5, 2, 25
	private static void solve(int[] a) {
		int n = a.length;

		BinaryTreeNode[] node = new BinaryTreeNode[n];
		node[0] = new BinaryTreeNode(a[0]);

		BinaryTreeNode tree = node[0];
		for (int i = 1; i < n; i++) {
			node[i] = new BinaryTreeNode(a[i]);
			tree.addNode(node[i]);
		}

		for (int i = 0; i < n; i++) {
			if (node[i].right != null) {
				System.out.println(a[i] + " " + node[i].right.data);
			} else {
				BinaryTreeNode parent = node[i].parent;

				if (parent != null && parent.right == node[i]) {
					// node[i] is a right node and has no right child
					System.out.println(a[i] + " -1");
				} else {
					// Go to parent and then as down right as you can
					if (parent != null && parent.right != null) {
						BinaryTreeNode next = parent.right;
						while (next.right != null) {
							next = next.right;
						}
						System.out.println(a[i] + " " + next.data);

					} else {
						System.out.println(a[i] + " -1");
					}
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		solve(a);
	}
}
