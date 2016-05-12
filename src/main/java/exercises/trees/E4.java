package exercises.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datastructures.MyBinarySearchTree;

/**
 * Given a binary search tree, design an algorithm which creates a linked list
 * of all the nodes at each depth (ie , if you have a tree with depth D, you�ll
 * have D linked lists).
 * 
 * @author lucas
 *
 */
public class E4 {

	public static <T extends Comparable<T>> void getAllNodesOfEachLevel(MyBinarySearchTree<T> current, Set<MyBinarySearchTree<T>> visited,
			List<List<MyBinarySearchTree<T>>> levelNodes, int level) {
		visited.add(current);
		if (levelNodes.size() <= level) {
			levelNodes.add(new ArrayList<MyBinarySearchTree<T>>());
		}
		levelNodes.get(level).add(current);
		if (!current.isLeaf()) {
			MyBinarySearchTree<T> leftChild = current.getLeftChild();
			if (leftChild != null) {
				getAllNodesOfEachLevel(leftChild, visited, levelNodes, (level + 1));
			}
			MyBinarySearchTree<T> rightChild = current.getRightChild();
			if (rightChild != null) {
				getAllNodesOfEachLevel(rightChild, visited, levelNodes, (level + 1));
			}
		}
	}

	/**
	 * Given a binary search tree, it creates a linked list of all the nodes at
	 * each depth (ie , if you have a tree with depth D, you�ll have D linked
	 * lists).
	 * 
	 * @param root
	 *            root of the tree
	 * @return linked list of all the nodes at each depth
	 */
	public static <T extends Comparable<T>> List<List<MyBinarySearchTree<T>>> getAllNodesOfEachLevel(MyBinarySearchTree<T> root) {
		List<List<MyBinarySearchTree<T>>> result = new ArrayList<List<MyBinarySearchTree<T>>>();
		getAllNodesOfEachLevel(root, new HashSet<MyBinarySearchTree<T>>(), result, 0);
		return result;
	}

	public static <T extends Comparable<T>> String getAllNodesOfEachLevelAsString(MyBinarySearchTree<T> root) {
		StringBuilder result = new StringBuilder("/");
		List<List<MyBinarySearchTree<T>>> levelList = getAllNodesOfEachLevel(root);

		for (List<MyBinarySearchTree<T>> nodeList : levelList) {
			MyBinarySearchTree<T> node;
			for (int n = 0; n < nodeList.size() - 1; n++) {
				node = nodeList.get(n);
				result.append(node.getData() + ", ");
			}

			node = nodeList.get(nodeList.size() - 1);
			result.append(node.getData());
			result.append("/");
		}

		return result.toString();
	}
}
