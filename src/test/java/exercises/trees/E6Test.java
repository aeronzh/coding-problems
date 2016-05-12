package exercises.trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datastructures.MyTreeNode;

// EXAMPLE
//             20
//          /     \
//         8      22
//        / \    / 
//       4  12  0
//      / \
//    10   14
//   /  \
//  9   11
//     /  \
//    1    3
public class E6Test {

	@Test
	public void testAncestor1() {
		MyTreeNode<String> root = new MyTreeNode<String>("20");

		MyTreeNode<String> l1c0 = new MyTreeNode<String>("8");
		MyTreeNode<String> l1c1 = new MyTreeNode<String>("22");

		root.addChild(l1c0);
		root.addChild(l1c1);

		MyTreeNode<String> l2c0 = new MyTreeNode<String>("4");
		MyTreeNode<String> l2c1 = new MyTreeNode<String>("12");
		MyTreeNode<String> l2c2 = new MyTreeNode<String>("0");
		l1c1.addChild(l2c2);
		l1c0.addChild(l2c0);
		l1c0.addChild(l2c1);

		MyTreeNode<String> l3c0 = new MyTreeNode<String>("10");
		MyTreeNode<String> l3c1 = new MyTreeNode<String>("14");
		l2c0.addChild(l3c0);
		l2c0.addChild(l3c1);

		MyTreeNode<String> l4c0 = new MyTreeNode<String>("9");
		MyTreeNode<String> l4c1 = new MyTreeNode<String>("11");
		l3c0.addChild(l4c0);
		l3c0.addChild(l4c1);

		MyTreeNode<String> l5c0 = new MyTreeNode<String>("1");
		MyTreeNode<String> l5c1 = new MyTreeNode<String>("3");
		l4c1.addChild(l5c0);
		l4c1.addChild(l5c1);

		MyTreeNode<String> result = E6.getFirstCommonAncestor(root, l5c1, l2c1); // 3 and 12 -> 8
		assertEquals("8", result.getData());
	}

	@Test
	public void testAncestor2() {
		MyTreeNode<String> root = new MyTreeNode<String>("20");

		MyTreeNode<String> l1c0 = new MyTreeNode<String>("8");
		MyTreeNode<String> l1c1 = new MyTreeNode<String>("22");

		root.addChild(l1c0);
		root.addChild(l1c1);

		MyTreeNode<String> l2c0 = new MyTreeNode<String>("4");
		MyTreeNode<String> l2c1 = new MyTreeNode<String>("12");
		MyTreeNode<String> l2c2 = new MyTreeNode<String>("0");
		l1c1.addChild(l2c2);
		l1c0.addChild(l2c0);
		l1c0.addChild(l2c1);

		MyTreeNode<String> l3c0 = new MyTreeNode<String>("10");
		MyTreeNode<String> l3c1 = new MyTreeNode<String>("14");
		l2c0.addChild(l3c0);
		l2c0.addChild(l3c1);

		MyTreeNode<String> l4c0 = new MyTreeNode<String>("9");
		MyTreeNode<String> l4c1 = new MyTreeNode<String>("11");
		l3c0.addChild(l4c0);
		l3c0.addChild(l4c1);

		MyTreeNode<String> l5c0 = new MyTreeNode<String>("1");
		MyTreeNode<String> l5c1 = new MyTreeNode<String>("3");
		l4c1.addChild(l5c0);
		l4c1.addChild(l5c1);

		MyTreeNode<String> result = E6.getFirstCommonAncestor(root, l2c2, l1c0); // 0 and 8 -> 20
		assertEquals("20", result.getData());
	}

}
