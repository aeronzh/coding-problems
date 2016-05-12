package exercises.trees;

import datastructures.MyTreeNode;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a
 * binary tree with minimal height.
 * 
 * @author lucas
 *
 */
public class E3 {

	private static <T> MyTreeNode<T> createBinaryTree(T[] sortedArray, int start, int end) {
		if (start <= end) {
			int middle = (start + end) / 2;
			MyTreeNode<T> root = new MyTreeNode<T>(sortedArray[middle]);
			MyTreeNode<T> left = createBinaryTree(sortedArray, start, middle - 1);
			MyTreeNode<T> right = createBinaryTree(sortedArray, middle + 1, end);
			if (left != null) {
				root.addChild(left);
			}
			if (right != null) {
				root.addChild(right);
			}

			return root;
		}
		return null;
	}

	/**
	 * Given a sorted (increasing order) array,returns a binary tree with
	 * minimal height.
	 * 
	 * @param sortedArray
	 *            sorted (increasing order) array
	 * @return a binary tree with minimal height.
	 */
	public static <T> MyTreeNode<T> createBinaryTree(T[] sortedArray) {
		return createBinaryTree(sortedArray, 0, sortedArray.length - 1);
	}

	public static void main(String[] args) {
		Integer[] sortedArray = { 1, 2, 3, 4, 5, 6, 7 };
		MyTreeNode<Integer> binaryTree = createBinaryTree(sortedArray);

		System.out.println(binaryTree.toString());

	}
}
