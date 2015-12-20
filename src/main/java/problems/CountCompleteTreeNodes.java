package problems;

import datastructures.MyBinaryTreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * @author lucas
 *
 */

//--------1
//------2   3
//-----4 5-6 7
public class CountCompleteTreeNodes {

	public static int solve(MyBinaryTreeNode<Integer> root) {
		MyBinaryTreeNode<Integer> node = root;
		
		int count = 1;
		while (node.getLeft() != null) {
			count++;
			node = node.getLeft();
		}
		
		
		// (2^#levels) - 1
		return (1<<count)-1;
	}
	
	
	public static void main(String[] args) {
		MyBinaryTreeNode<Integer> root = new MyBinaryTreeNode<Integer>(1);
		MyBinaryTreeNode<Integer> two = new MyBinaryTreeNode<Integer>(2);
		MyBinaryTreeNode<Integer> three = new MyBinaryTreeNode<Integer>(3);
		MyBinaryTreeNode<Integer> four = new MyBinaryTreeNode<Integer>(4);
		MyBinaryTreeNode<Integer> five = new MyBinaryTreeNode<Integer>(5);
		MyBinaryTreeNode<Integer> six = new MyBinaryTreeNode<Integer>(6);
		MyBinaryTreeNode<Integer> seven = new MyBinaryTreeNode<Integer>(7);
		
		root.setLeft(two);
		root.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		
		three.setLeft(six);
		three.setRight(seven);

		System.out.println(solve(root));

	}

}
