package exercises.trees;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import datastructures.MyTreeNode;

public class E8Test {

	@Test
	public void testSum1() {
		MyTreeNode<Integer> root = new MyTreeNode<Integer>(20);

		MyTreeNode<Integer> l1c0 = new MyTreeNode<Integer>(8);
		MyTreeNode<Integer> l1c1 = new MyTreeNode<Integer>(22);

		root.addChild(l1c0);
		root.addChild(l1c1);

		MyTreeNode<Integer> l2c0 = new MyTreeNode<Integer>(4);
		MyTreeNode<Integer> l2c1 = new MyTreeNode<Integer>(12);
		MyTreeNode<Integer> l2c2 = new MyTreeNode<Integer>(0);
		l1c1.addChild(l2c2);
		l1c0.addChild(l2c0);
		l1c0.addChild(l2c1);

		MyTreeNode<Integer> l3c0 = new MyTreeNode<Integer>(10);
		MyTreeNode<Integer> l3c1 = new MyTreeNode<Integer>(14);
		l2c0.addChild(l3c0);
		l2c0.addChild(l3c1);

		MyTreeNode<Integer> l4c0 = new MyTreeNode<Integer>(9);
		MyTreeNode<Integer> l4c1 = new MyTreeNode<Integer>(11);
		l3c0.addChild(l4c0);
		l3c0.addChild(l4c1);

		MyTreeNode<Integer> l5c0 = new MyTreeNode<Integer>(1);
		MyTreeNode<Integer> l5c1 = new MyTreeNode<Integer>(3);
		l4c1.addChild(l5c0);
		l4c1.addChild(l5c1);

		MyTreeNode<Integer> l6c1 = new MyTreeNode<Integer>(0);
		l5c1.addChild(l6c1);

		List<List<MyTreeNode<Integer>>> result = E8.getPaths(root, 14);
		assertEquals("[[4 10][14][11 3][11 3 0]]", E8.printResultListAsList(result));
	}

}
