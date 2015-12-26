package problems;

import datastructures.MyBinaryTreeNode;

public class PostorderTraversal {

	// Visit left subtree
	// Visit right sub tree
	// Visit root
	private static void postorder(MyBinaryTreeNode<Integer> root) {
		if (root.getLeft() != null) {
			postorder(root.getLeft());
		}

		if (root.getRight() != null) {
			postorder(root.getRight());
		}
		System.out.print(root.getData() + " ");
	}

	public static void main(String[] args) {
		//  4, 6, 5, 2, 3, 1

		MyBinaryTreeNode<Integer> root = new MyBinaryTreeNode<Integer>(1);
		MyBinaryTreeNode<Integer> two = new MyBinaryTreeNode<Integer>(2);
		MyBinaryTreeNode<Integer> three = new MyBinaryTreeNode<Integer>(3);
		MyBinaryTreeNode<Integer> four = new MyBinaryTreeNode<Integer>(4);
		MyBinaryTreeNode<Integer> five = new MyBinaryTreeNode<Integer>(5);
		MyBinaryTreeNode<Integer> six = new MyBinaryTreeNode<Integer>(6);

		root.setLeft(two);
		root.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		five.setLeft(six);

		System.out.println(root);
		postorder(root);

	}

}
