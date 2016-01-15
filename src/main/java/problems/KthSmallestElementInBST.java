package problems;

import java.util.Stack;

import datastructures.MyBinarySearchTree;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it. (1 <= k <= BST's total elements)
 * 
 * @author lucas
 *
 */

//                      8
//                    /    \
//                   4      12
//                  / \    /  \
//                 2   6  10   14
//                       /  \    \
//                      9    11   17
//
// 2 4 6 8 9 10 11 12 14 17
// 
public class KthSmallestElementInBST {
	static int count = 0;

	public static void solve(MyBinarySearchTree<Integer> t, int k) {
		// inorder traversal
		if (t.getLeftChild() != null) {
			// go to left
			solve(t.getLeftChild(), k);
		}

		count++;
		System.out.println(t.getData() + "  count=" + count);

		if (t.getRightChild() != null) {
			// go to right
			solve(t.getRightChild(), k);
		}
	}

	/**
	 * 1) Create an empty stack S.
	 * 
	 * 2) Initialize current node as root
	 * 
	 * 3) Push the current node to S and set current = current->left until
	 * current is NULL
	 * 
	 * 4) If current is NULL and stack is not empty then
	 * 
	 * --- a) Pop the top item from stack.
	 * 
	 * --- b) Print the popped item, set current = popped_item->right
	 * 
	 * --- c) Go to step 3.
	 * 
	 * 5) If current is NULL and stack is empty then we are done.
	 * 
	 * @param t
	 * @param k
	 */
	public static void solveStack(MyBinarySearchTree<Integer> t, int k) {
		Stack<MyBinarySearchTree<Integer>> stack = new Stack<MyBinarySearchTree<Integer>>();

		MyBinarySearchTree<Integer> node = t;
		stack.push(node);

		while (!stack.isEmpty()) {
			while (node.getLeftChild() != null) {
				node = node.getLeftChild();
				stack.push(node);
			}

			node = stack.pop();
			k--;
			if (k == 0) {
				System.out.println(node.getData());
				break;
			}

			if (node.getRightChild() != null) {
				node = node.getRightChild();
				stack.push(node);
			}
		}

	}

	public static void main(String[] args) {
		MyBinarySearchTree<Integer> t = new MyBinarySearchTree<Integer>(8);
		t.addNode(4);
		t.addNode(12);
		t.addNode(2);
		t.addNode(6);
		t.addNode(10);
		t.addNode(9);
		t.addNode(14);
		t.addNode(17);
		t.addNode(11);

		System.out.println(t.toString());

		solveStack(t, 4);
	}

}
