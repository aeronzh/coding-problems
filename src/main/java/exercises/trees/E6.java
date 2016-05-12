package exercises.trees;

import datastructures.MyTreeNode;

/**
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes in a binary tree. Avoid storing additional nodes in a data structure
 * NOTE: This is not necessarily a binary search tree.
 * 
 * @author lucas
 *
 */
public class E6 {

	/**
	 * Get the first common ancestor of two nodes in a binary tree.
	 * 
	 * @param root
	 *            the root of the tree
	 * @param node1
	 *            node 1
	 * @param node2
	 *            node 2
	 * @return the first common ancestor of the two nodes
	 */
	public static <T> MyTreeNode<T> getFirstCommonAncestor(MyTreeNode<T> root, MyTreeNode<T> node1, MyTreeNode<T> node2) {
		MyTreeNode<T> leftChild = root.getChildren().size() > 0 ? root.getChildren().get(0) : null;
		MyTreeNode<T> rightChild = root.getChildren().size() > 1 ? root.getChildren().get(1) : null;

		if (rootCoversNode(leftChild, node1) && rootCoversNode(leftChild, node2)) {
			return getFirstCommonAncestor(leftChild, node1, node2);
		} else if (rootCoversNode(rightChild, node1) && rootCoversNode(rightChild, node2)) {
			return getFirstCommonAncestor(rightChild, node1, node2);
		} else {
			return root;
		}
	}

	/**
	 * Returns true if root node covers node.
	 * 
	 * @param root
	 *            The possible root node
	 * @param node
	 *            Node to check if it is covered by root
	 * @return true if root covers (is ancestor of) node. Returns false
	 *         otherwise.
	 */
	private static <T> boolean rootCoversNode(MyTreeNode<T> root, MyTreeNode<T> node) {
		boolean result;

		if (root == null) {
			result = false;
		} else if (root.equals(node)) {
			result = true;
		} else {
			MyTreeNode<T> leftChild = root.getChildren().size() > 0 ? root.getChildren().get(0) : null;
			MyTreeNode<T> rightChild = root.getChildren().size() > 1 ? root.getChildren().get(1) : null;
			result = rootCoversNode(leftChild, node) || rootCoversNode(rightChild, node);
		}

		return result;
	}

}
