package exercises.trees;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import datastructures.MyBinarySearchTree;

public class E4Test {

	@Test
	public void testLevels1() {
		MyBinarySearchTree<Integer> searchTree = new MyBinarySearchTree<Integer>(4);
		searchTree.addNode(2);
		searchTree.addNode(6);
		searchTree.addNode(1);
		searchTree.addNode(3);
		searchTree.addNode(5);
		searchTree.addNode(7);
		List<List<MyBinarySearchTree<Integer>>> result = E4.getAllNodesOfEachLevel(searchTree);
		assertEquals("[[[4->[2->[1][3]][6->[5][7]]]], [[2->[1][3]], [6->[5][7]]], [[1], [3], [5], [7]]]".trim(), result.toString().trim());
	}

	@Test
	public void testLevelsString1() {
		MyBinarySearchTree<Integer> searchTree = new MyBinarySearchTree<Integer>(4);
		searchTree.addNode(2);
		searchTree.addNode(6);
		searchTree.addNode(1);
		String result = E4.getAllNodesOfEachLevelAsString(searchTree);
		System.out.println(result);
		assertEquals("/4/2, 6/1/", result);
	}
}
