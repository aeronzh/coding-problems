package exercises.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import datastructures.MyTreeNode;

/**
 * Implement a function to check if a tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that no two leaf nodes
 * differ in distance from the root by more than one.
 * 
 * @author lucas
 *
 */
public class E1 {

	/**
	 * Collect the level for each leaf in a list
	 * 
	 * @param node
	 *            current node
	 * @param distances
	 *            collected leaf levels
	 * @param level
	 *            current level
	 */
	private static <T> void getLeafDistancesFromRoot(MyTreeNode<T> node, List<Integer> distances, int level) {
		if (node.isLeaf()) {
			distances.add(level);
		} else {
			for (MyTreeNode<T> child : node.getChildren()) {
				getLeafDistancesFromRoot(child, distances, (level + 1));
			}
		}
	}

	/**
	 * Check whether a tree is blanced or not.
	 * 
	 * @param root
	 * @return true if the tree is balanced. Returns false otherwise.
	 */
	public static <T> boolean isBalanced(MyTreeNode<T> root) {
		boolean result = true;

		List<Integer> distances = new ArrayList<Integer>();
		getLeafDistancesFromRoot(root, distances, 0);

		// Sort list
		Collections.sort(distances);

		int first = distances.get(0);
		int last = distances.get(distances.size() - 1);
		if (Math.abs(first - last) > 1) {
			result = false;
		}

		return result;
	}

}
