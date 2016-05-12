package exercises.trees;

import datastructures.MyBinarySearchTree;

/**
 * Write an algorithm to find the "next" node (ie , in-order successor) of a
 * given node in a binary search tree where each node has a link to its parent.
 * 
 * 
 * @author lucas
 *
 */

// EXAMPLE
//              20
//             /  \
//            8   22
//           / \
//          4  12
//            /  \
//           10  14
//             \
//             11
//in-order successor of 8 is 10, in-order successor of 10 is 12 and in-order successor of 14 is 20.

public class E5 {

	/**
	 * Get the "next" node (ie , in-order successor) of a given node in a binary
	 * search tree.
	 * 
	 * @param node
	 *            the node we of which we want the inorder successor.
	 * @return MyBinarySearchTree in order successor of node.
	 */
	public static <T extends Comparable<T>> MyBinarySearchTree<T> getInOrderSuccessor(MyBinarySearchTree<T> node) {
		MyBinarySearchTree<T> result = null;
		// Check its right child first. If the right child is not null, traverse to the right child and then always to the left.
		// If the right child is null, traverse up until you find a node x that is larger. Node x is the in-order successor.
		MyBinarySearchTree<T> rightChild = node.getRightChild();
		MyBinarySearchTree<T> next;

		if (rightChild != null) {
			// Go right once.
			next = rightChild;
			while (next != null) {
				if (next.getLeftChild() != null) {
					// always go left
					next = next.getLeftChild();
				}

				if (next.getData().compareTo(node.getData()) > 0) {
					result = next;
					break;
				}
			}
		} else {
			// Go up
			next = node.getParent();
			while (next != null) {
				if (next.getData().compareTo(node.getData()) > 0) {
					result = next;
					break;
				} else {
					next = next.getParent();
				}
			}
		}

		return result;
	}

}
