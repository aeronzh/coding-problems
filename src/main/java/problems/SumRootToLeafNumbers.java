package problems;

import java.util.Stack;

import datastructures.MyBinaryTreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number. Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * ----1
 * 
 * ---/ \
 * 
 * --2---3
 * 
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path
 * 1->3 represents the number 13. Return the sum = 12 + 13 = 25.
 * 
 * 
 * @author lucas
 *
 */

//--------1
//------2   3
//-----4 5-6 7
//
// 124 + 125 + 136 + 137 = 522
public class SumRootToLeafNumbers {

	// post-order traversal
	public static int solve(MyBinaryTreeNode<Integer> root, int level, Stack<Integer> stack, int sum) {		
		stack.add(root.getData());

		boolean isLeaf = true;

		if (root.getLeft() != null) {
			isLeaf = false;
			// go left
			sum = solve(root.getLeft(), (level + 1), stack, sum);
		}

		if (root.getRight() != null) {
			isLeaf = false;
			// go right
			sum +=solve(root.getRight(), (level + 1), stack, sum);
		}

		int num = 0;
		if (isLeaf) {
			// do number here
			Stack<Integer> tempStack = new Stack<Integer>();
			tempStack.addAll(stack);
			int t = 1;
			while (!tempStack.isEmpty()) {
				num += tempStack.pop() * t;
				t *= 10;
			}
			
			System.out.println(sum+" + "+num+" = " + (sum+num));
			sum += num;
			
		}

		stack.pop();
		
		return num;
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

		int sum = solve(root, 1, new Stack<Integer>(), 0);
		System.out.println(sum);
	}

}
