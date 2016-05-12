package problems;

import datastructures.MyBinarySearchTree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 * @author lucas
 *
 */

//                  8
//               /    \
//              4      12
//             / \    /  \
//            2   6  10   14
//                  /  \    \
//                 9    11   17
//
//2 4 6 8 9 10 11 12 14 17
//
public class LowestCommonAncestorBST {

	public static void solve(MyBinarySearchTree<Integer> root, MyBinarySearchTree<Integer> a, MyBinarySearchTree<Integer> b) {
		MyBinarySearchTree<Integer> node = root;
		while ((a.getData()<node.getData() && b.getData()<node.getData()) || (a.getData()>node.getData() && b.getData()>node.getData())) {
			if (a.getData()<node.getData()) {
				node = node.getLeftChild();
			} else {
				node = node.getRightChild();
			}
		}
		
		System.out.println(node.getData());
	}
	
	public static void main(String[] args) {
		MyBinarySearchTree<Integer> t = new MyBinarySearchTree<Integer>(8);
		t.addNode(4);
		t.addNode(12);
		t.addNode(2);
		t.addNode(6);
		t.addNode(10);
		MyBinarySearchTree<Integer> a = t.addNode(9);
		MyBinarySearchTree<Integer> b = t.addNode(14);
		t.addNode(17);
		MyBinarySearchTree<Integer> c =  t.addNode(11);

		System.out.println(t.toString());
		solve(t, a, b); // 12
	}


}
