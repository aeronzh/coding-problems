package problems;

import java.util.ArrayList;
import java.util.List;

import datastructures.MyBinaryTreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example, given the below binary tree and sum = 22,
 * 
 * 
 * the method returns the following:
 * 
 * [ [5,4,11,2], [5,8,4,5] ]
 * 
 * @author lucas
 *
 */

//             5
//            / \
//           4   8
//          /   / \
//         11  13  4
//        /  \    / \
//       7    2  5   1

public class PathSum2 {

	private static List<List<MyBinaryTreeNode<Integer>>> solve(MyBinaryTreeNode<Integer> root, int n, int sum, List<MyBinaryTreeNode<Integer>> path, List<List<MyBinaryTreeNode<Integer>>> result) {
		MyBinaryTreeNode<Integer> left = root.getLeft();
		MyBinaryTreeNode<Integer> right = root.getRight();
		
		if (sum == n && (left == null && right == null)) {
			result.add(new ArrayList<MyBinaryTreeNode<Integer>>(path));
		} else {

			if (left != null || right != null) {
				if (left != null) {
					// go left
					path.add(left);
					solve(left, n, (sum + left.getData()), path, result);
					path.remove(path.size() - 1);
				}

				if (right != null) {
					//go right
					path.add(right);
					solve(right, n, (sum + right.getData()), path, result);
					path.remove(path.size() - 1);
				}

			}

		}

		return result;
	}
	
	public static List<List<Integer>> solve(MyBinaryTreeNode<Integer> root, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		List<MyBinaryTreeNode<Integer>> startPath =  new ArrayList<MyBinaryTreeNode<Integer>>();
		startPath.add(root);
		
		List<List<MyBinaryTreeNode<Integer>>> list = solve(root, n, root.getData(), startPath, new ArrayList<List<MyBinaryTreeNode<Integer>>>());
		
		for (List<MyBinaryTreeNode<Integer>> nodeList:list) {
			List<Integer> temp = new ArrayList<Integer>();
			for (MyBinaryTreeNode<Integer> node:nodeList) {
				temp.add(node.getData());
			}
			
			result.add(temp);
		}
		
		return result;
	}

	public static void main(String[] args) {
		MyBinaryTreeNode<Integer> root = new MyBinaryTreeNode<Integer>(5);
		MyBinaryTreeNode<Integer> four = new MyBinaryTreeNode<Integer>(4);
		MyBinaryTreeNode<Integer> eight = new MyBinaryTreeNode<Integer>(8);
		MyBinaryTreeNode<Integer> eleven = new MyBinaryTreeNode<Integer>(11);
		MyBinaryTreeNode<Integer> thirteen = new MyBinaryTreeNode<Integer>(13);
		MyBinaryTreeNode<Integer> four_2 = new MyBinaryTreeNode<Integer>(4);
		MyBinaryTreeNode<Integer> seven = new MyBinaryTreeNode<Integer>(7);
		MyBinaryTreeNode<Integer> two = new MyBinaryTreeNode<Integer>(2);
		MyBinaryTreeNode<Integer> five = new MyBinaryTreeNode<Integer>(5);
		MyBinaryTreeNode<Integer> one = new MyBinaryTreeNode<Integer>(1);

		root.setLeft(four);
		root.setRight(eight);

		four.setLeft(eleven);

		eight.setLeft(thirteen);
		eight.setRight(four_2);

		eleven.setLeft(seven);
		eleven.setRight(two);

		four_2.setLeft(five);
		four_2.setRight(one);
		
		System.out.println(solve(root, 22));

	}

}
