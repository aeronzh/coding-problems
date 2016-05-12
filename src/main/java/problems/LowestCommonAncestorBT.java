package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructures.MyBinaryTreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * @author lucas
 *
 */

//                  8
//                /    \
//               4      12
//              / \    /  \
//             2   6  10   14
//                    / \    \
//                   9   11   17
//
//2 4 6 8 9 10 11 12 14 17
//
public class LowestCommonAncestorBT {

	private static List<Integer> dfs(MyBinaryTreeNode<Integer> root, MyBinaryTreeNode<Integer> n, Map<Integer, Integer> backtrace, Set<MyBinaryTreeNode<Integer>> visited) {

		if (n.getData().equals(root.getData())) {
			System.out.println("Found");
			List<Integer> path = new ArrayList<Integer>();
			Integer key = n.getData();
			while (backtrace.containsKey(key)) {
				path.add(key);
				key = backtrace.get(key);
			}
			path.add(key);
			return path;
		} else {
			List<Integer> path = new ArrayList<Integer>();
			visited.add(root);
			if (root.getLeft() != null) {
				if (!visited.contains(root.getLeft())) {
					backtrace.put(root.getLeft().getData(), root.getData());
					path = dfs(root.getLeft(), n, backtrace, visited);
				}
			}

			if (!path.isEmpty()) {
				return path;
			}

			if (root.getRight() != null) {
				if (!visited.contains(root.getRight())) {
					backtrace.put(root.getRight().getData(), root.getData());
					path = dfs(root.getRight(), n, backtrace, visited);
				}
			}

			return path;
		}
	}

	public static void solve(MyBinaryTreeNode<Integer> root, MyBinaryTreeNode<Integer> a, MyBinaryTreeNode<Integer> b) {
		Map<Integer, Integer> backtrace = new HashMap<Integer, Integer>();
		List<Integer> pathA = dfs(root, a, backtrace, new HashSet<MyBinaryTreeNode<Integer>>());
		List<Integer> pathB = dfs(root, b, backtrace, new HashSet<MyBinaryTreeNode<Integer>>());
		System.out.println(pathA);
		System.out.println(pathB);

		int iA = pathA.size() - 1;
		int iB = pathB.size() - 1;
		while (iA >= 0 && iB >= 0) {
			if (pathA.get(iA) != pathB.get(iB)) {
				System.out.println(pathA.get(iA + 1));
				return;
			}
			iA--;
			iB--;
		}

		if (iB < 0 && iA >= 0) {
			System.out.println(pathA.get(iA + 1));
		} else if (iA < 0 && iB >= 0) {
			System.out.println(pathA.get(iB + 1));
		}
	}

	public static void main(String[] args) {
		MyBinaryTreeNode<Integer> root = new MyBinaryTreeNode<Integer>(8);
		MyBinaryTreeNode<Integer> four = new MyBinaryTreeNode<Integer>(4);
		MyBinaryTreeNode<Integer> twelve = new MyBinaryTreeNode<Integer>(12);
		MyBinaryTreeNode<Integer> two = new MyBinaryTreeNode<Integer>(2);
		MyBinaryTreeNode<Integer> six = new MyBinaryTreeNode<Integer>(6);
		MyBinaryTreeNode<Integer> ten = new MyBinaryTreeNode<Integer>(10);
		MyBinaryTreeNode<Integer> fourteen = new MyBinaryTreeNode<Integer>(14);
		MyBinaryTreeNode<Integer> nine = new MyBinaryTreeNode<Integer>(9);
		MyBinaryTreeNode<Integer> eleven = new MyBinaryTreeNode<Integer>(11);
		MyBinaryTreeNode<Integer> seventeen = new MyBinaryTreeNode<Integer>(17);

		root.setLeft(four);
		root.setRight(twelve);
		four.setLeft(two);
		four.setRight(six);
		twelve.setLeft(ten);
		twelve.setRight(fourteen);
		ten.setLeft(nine);
		ten.setRight(eleven);
		fourteen.setRight(seventeen);

		solve(root, two, seventeen);

	}

}
