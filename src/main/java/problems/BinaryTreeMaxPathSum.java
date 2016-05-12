package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datastructures.MyBinaryTreeNode;

/**
 * Given a binary tree, find the maximum path sum. The path may start and end at
 * any node in the tree. For example, given the below binary tree
 * 
 * 1
 *
 * / \
 * 
 * 2 3
 * 
 * the result is 6.
 * 
 * @author lucas
 *
 */
public class BinaryTreeMaxPathSum {

	private static void dfs(MyBinaryTreeNode<Integer> current, Set<MyBinaryTreeNode<Integer>> visited) {
		System.out.println("Visiting " + current.getData());
		visited.add(current);

		List<MyBinaryTreeNode<Integer>> children = new ArrayList<MyBinaryTreeNode<Integer>>();
		if (current.getLeft() != null) {
			children.add(current.getLeft());
		}

		if (current.getRight() != null) {
			children.add(current.getRight());
		}

		for (MyBinaryTreeNode<Integer> node : children) {
			if (!visited.contains(node)) {
				dfs(node, visited);
			}
		}
	}

	public static void main(String[] args) {
		MyBinaryTreeNode<Integer> root = new MyBinaryTreeNode<Integer>(2);
		MyBinaryTreeNode<Integer> seven = new MyBinaryTreeNode<Integer>(7);
		MyBinaryTreeNode<Integer> five = new MyBinaryTreeNode<Integer>(5);
		MyBinaryTreeNode<Integer> two = new MyBinaryTreeNode<Integer>(2);
		MyBinaryTreeNode<Integer> six = new MyBinaryTreeNode<Integer>(6);
		MyBinaryTreeNode<Integer> nine = new MyBinaryTreeNode<Integer>(9);
		MyBinaryTreeNode<Integer> five2 = new MyBinaryTreeNode<Integer>(5);
		MyBinaryTreeNode<Integer> eleven = new MyBinaryTreeNode<Integer>(11);
		MyBinaryTreeNode<Integer> four = new MyBinaryTreeNode<Integer>(4);

		root.setLeft(seven);
		root.setRight(five);

		seven.setLeft(two);
		seven.setRight(six);

		six.setLeft(five2);
		six.setRight(eleven);

		five.setRight(nine);
		nine.setLeft(four);

		dfs(root, new HashSet<MyBinaryTreeNode<Integer>>());

        // TODO

	}
}
