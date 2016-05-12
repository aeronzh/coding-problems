package exercises.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.MyTreeNode;

/**
 * You are given a binary tree in which each node contains a value. Design an
 * algorithm to print all paths which sum up to that value. Note that it can be
 * any path in the tree - it does not have to start at the root.
 * 
 * @author lucas
 *
 */

//EXAMPLE
//                        20
//                     /     \
//                    8      22
//                   / \    / 
//                  4  12  0
//                 / \
//               10   14
//              /  \
//             9   11
//                /  \
//               1    3
//                   /
//                  0
public class E8 {
	/**
	 * Get all paths containing in the List in String representation.
	 * 
	 * @param foundPaths
	 */
	public static String printResultListAsList(List<List<MyTreeNode<Integer>>> foundPaths) {
		StringBuilder result = new StringBuilder("[");
		for (List<MyTreeNode<Integer>> path : foundPaths) {
			result.append("[");
			for (int i = 0; i < path.size() - 1; i++) {
				result.append(path.get(i).getData() + " ");
			}
			result.append(path.get(path.size() - 1).getData());
			result.append("]");
		}
		result.append("]");
		return result.toString();
	}

	/**
	 * Sum check all the paths starting with node root.
	 * 
	 * @param root
	 *            the starting node of the path
	 * @param path
	 *            the current nodes in the path
	 * @param sum
	 *            the searched sum
	 * @param intermediateSum
	 *            the sum of the current path
	 * @param foundPaths
	 *            List containing all found paths so far
	 */
	private static void sumUsingDFS(MyTreeNode<Integer> root, List<MyTreeNode<Integer>> path, int sum, int intermediateSum, List<List<MyTreeNode<Integer>>> foundPaths) {
		Integer value = root.getData();
		intermediateSum += value;

		List<MyTreeNode<Integer>> newpath = new ArrayList<MyTreeNode<Integer>>();
		newpath.addAll(path);
		newpath.add(root);

		if (intermediateSum == sum) {
			foundPaths.add(newpath);
		}

		for (MyTreeNode<Integer> child : root.getChildren()) {
			sumUsingDFS(child, newpath, sum, intermediateSum, foundPaths);
		}

	}

	/**
	 * Iterates all the nodes in the tree using a BFS search and searches all
	 * possible paths starting from a node using DFS.
	 * 
	 * @param root
	 *            the root of the tree
	 * @param sum
	 *            the sum we are searching for
	 */
	private static List<List<MyTreeNode<Integer>>> bfs(MyTreeNode<Integer> root, int sum) {
		List<List<MyTreeNode<Integer>>> result = new ArrayList<List<MyTreeNode<Integer>>>();
		Queue<MyTreeNode<Integer>> queue = new LinkedList<MyTreeNode<Integer>>();
		queue.add(root);

		while (!queue.isEmpty()) {
			MyTreeNode<Integer> node = queue.poll();
			sumUsingDFS(node, new ArrayList<MyTreeNode<Integer>>(), sum, 0, result);
			for (MyTreeNode<Integer> child : node.getChildren()) {
				queue.add(child);
			}
		}

		return result;
	}

	/**
	 * Given a binary tree in which each node contains a value returns all paths
	 * which sum up to that value sum. Note that it can be any path in the tree
	 * it does not have to start at the root.
	 * 
	 * @param root
	 * @param sum
	 * @return List of all the paths found summing up to sum.
	 */
	public static List<List<MyTreeNode<Integer>>> getPaths(MyTreeNode<Integer> root, int sum) {
		return bfs(root, sum);
	}

}
