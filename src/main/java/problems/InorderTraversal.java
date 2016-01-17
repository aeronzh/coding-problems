package problems;

import datastructures.MyBinaryTreeNode;

public class InorderTraversal {

	// Visit left subtree
	// Visit root
	// Visit right sub tree
	private static void inorder(MyBinaryTreeNode<Integer> root) {
		if (root.getLeft() != null) {
			inorder(root.getLeft());
		}

		System.out.print(root.getData() + " ");

		if (root.getRight() != null) {
			inorder(root.getRight());
		}
	}

	public static void main(String[] args) {
		//  2, 7, 5, 6, 11, 2, 5, 4, 9

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

		System.out.println(root);
		inorder(root);

	}

}
