package exercises.trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datastructures.MyBinarySearchTree;

public class E5Test {

	@Test
	public void testInorderSuccessor1() {
		MyBinarySearchTree<Integer> searchTree = new MyBinarySearchTree<Integer>(20);
		searchTree.addNode(8);
		searchTree.addNode(22);
		searchTree.addNode(4);
		searchTree.addNode(12);
		searchTree.addNode(10);
		searchTree.addNode(14);
		MyBinarySearchTree<Integer> searchNode = searchTree.addNode(11);

		MyBinarySearchTree<Integer> result = E5.getInOrderSuccessor(searchNode);
		assertEquals(new Integer(12), result.getData());
	}

	@Test
	public void testInorderSuccessor2() {
		MyBinarySearchTree<Integer> searchTree = new MyBinarySearchTree<Integer>(20);
		MyBinarySearchTree<Integer> searchNode = searchTree.addNode(8);
		searchTree.addNode(22);
		searchTree.addNode(4);
		searchTree.addNode(12);
		searchTree.addNode(10);
		searchTree.addNode(14);
		searchTree.addNode(11);

		MyBinarySearchTree<Integer> result = E5.getInOrderSuccessor(searchNode);
		assertEquals(new Integer(10), result.getData());
	}

	@Test
	public void testInorderSuccessor3() {
		MyBinarySearchTree<Integer> searchTree = new MyBinarySearchTree<Integer>(20);
		searchTree.addNode(8);
		searchTree.addNode(22);
		searchTree.addNode(4);
		searchTree.addNode(12);
		searchTree.addNode(10);
		MyBinarySearchTree<Integer> searchNode = searchTree.addNode(14);
		searchTree.addNode(11);

		MyBinarySearchTree<Integer> result = E5.getInOrderSuccessor(searchNode);
		assertEquals(new Integer(20), result.getData());
	}

	@Test
	public void testInorderSuccessor4() {
		MyBinarySearchTree<Integer> searchTree = new MyBinarySearchTree<Integer>(20);
		searchTree.addNode(8);
		searchTree.addNode(22);
		MyBinarySearchTree<Integer> searchNode = searchTree.addNode(4);
		searchTree.addNode(12);
		searchTree.addNode(10);
		searchTree.addNode(14);
		searchTree.addNode(11);

		MyBinarySearchTree<Integer> result = E5.getInOrderSuccessor(searchNode);
		assertEquals(new Integer(8), result.getData());
	}

}
