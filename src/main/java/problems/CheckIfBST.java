package problems;

import com.lucaslouca.datastructures.MyBinaryTreeNode;

public class CheckIfBST {

	private static int prev;

	// Do Inorder Traversal and check if output is ordered
	//  1. Visit left subtree
	// 	2. Visit root
	//  3. Visit right sub tree
	private static boolean isBST(MyBinaryTreeNode<Integer> node) {
		if (node != null) {
			if (!isBST(node.getLeft())) {
				return false;
			}

			System.out.println(node.getData() + " prev = " + prev);
			if (prev != 0 && node.getData() < prev) {
				return false;
			}
			prev = node.getData();

			if (!isBST(node.getRight())) {
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {
		//      4
		//     / \
		//    2   5
		//   / \
		//  1   3

		MyBinaryTreeNode<Integer> root = new MyBinaryTreeNode<Integer>(4);
		MyBinaryTreeNode<Integer> one = new MyBinaryTreeNode<Integer>(1);
		MyBinaryTreeNode<Integer> five = new MyBinaryTreeNode<Integer>(5);
		MyBinaryTreeNode<Integer> two = new MyBinaryTreeNode<Integer>(2);
		MyBinaryTreeNode<Integer> three = new MyBinaryTreeNode<Integer>(3);

		MyBinaryTreeNode<Integer> seven = new MyBinaryTreeNode<Integer>(7);

		root.setLeft(two);
		root.setRight(five);

		two.setLeft(one);
		two.setRight(three);

		System.out.println(isBST(root));

	}
}
