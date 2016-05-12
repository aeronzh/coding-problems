package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructures.MyBinaryTreeNode;

//				   8
//				/    \
//			   4      12
//            / \    /  \
//           2   6  10   14
//                  / \    \
//                 9   11   17
//
// 8 4 2 6 12 10 9 11 14 17
public class FlattenBinaryTree {

	public static void solve(MyBinaryTreeNode<Integer> root) {
		List<Integer> list = new ArrayList<Integer>();

		Stack<MyBinaryTreeNode<Integer>> stack = new Stack<MyBinaryTreeNode<Integer>>();
		MyBinaryTreeNode<Integer> node = root;
		stack.push(node);
		while (!stack.isEmpty()) {
			
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
	}
}
