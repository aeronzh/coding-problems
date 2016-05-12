package exercises.trees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datastructures.MyTreeNode;

public class E1Test {

	@Test
	public void testBalanced1() {
		MyTreeNode<String> root = new MyTreeNode<String>("ROOT");
		{
			MyTreeNode<String> l1c0 = new MyTreeNode<String>("1.0");
			MyTreeNode<String> l1c1 = new MyTreeNode<String>("1.1");

			root.addChild(l1c0);
			root.addChild(l1c1);

			{
				MyTreeNode<String> l2c0 = new MyTreeNode<String>("2.0");
				MyTreeNode<String> l2c1 = new MyTreeNode<String>("2.1");

				l1c0.addChild(l2c0);
				l1c0.addChild(l2c1);

				MyTreeNode<String> l2c2 = new MyTreeNode<String>("2.2");
				MyTreeNode<String> l2c3 = new MyTreeNode<String>("2.3");

				l1c1.addChild(l2c2);
				l1c1.addChild(l2c3);

				{
					MyTreeNode<String> l3c0 = new MyTreeNode<String>("3.0");
					MyTreeNode<String> l3c1 = new MyTreeNode<String>("3.1");

					l2c0.addChild(l3c0);
					l2c0.addChild(l3c1);
				}
			}
		}

		assertTrue(E1.isBalanced(root));
	}

	@Test
	public void testBalanced2() {
		MyTreeNode<String> root = new MyTreeNode<String>("ROOT");
		{
			MyTreeNode<String> l1c0 = new MyTreeNode<String>("1.0");
			MyTreeNode<String> l1c1 = new MyTreeNode<String>("1.1");

			root.addChild(l1c0);
			root.addChild(l1c1);

			{
				MyTreeNode<String> l2c0 = new MyTreeNode<String>("2.0");
				MyTreeNode<String> l2c1 = new MyTreeNode<String>("2.1");

				l1c0.addChild(l2c0);
				l1c0.addChild(l2c1);

				MyTreeNode<String> l2c2 = new MyTreeNode<String>("2.2");
				MyTreeNode<String> l2c3 = new MyTreeNode<String>("2.3");

				l1c1.addChild(l2c2);
				l1c1.addChild(l2c3);

				{
					MyTreeNode<String> l3c0 = new MyTreeNode<String>("3.0");
					MyTreeNode<String> l3c1 = new MyTreeNode<String>("3.1");

					l2c0.addChild(l3c0);
					l2c0.addChild(l3c1);

					{
						MyTreeNode<String> l4c0 = new MyTreeNode<String>("4.0");
						l3c0.addChild(l4c0);
					}
				}
			}
		}

		assertFalse(E1.isBalanced(root));
	}

	@Test
	public void testBalanced3() {
		MyTreeNode<String> root = new MyTreeNode<String>("ROOT");
		assertTrue(E1.isBalanced(root));
	}

	@Test
	public void testBalanced4() {
		MyTreeNode<String> root = new MyTreeNode<String>("ROOT");
		{
			MyTreeNode<String> l1c0 = new MyTreeNode<String>("1.0");
			MyTreeNode<String> l1c1 = new MyTreeNode<String>("1.1");

			root.addChild(l1c0);
			root.addChild(l1c1);

			{
				MyTreeNode<String> l2c0 = new MyTreeNode<String>("2.0");
				MyTreeNode<String> l2c1 = new MyTreeNode<String>("2.1");

				l1c0.addChild(l2c0);
				l1c0.addChild(l2c1);

				MyTreeNode<String> l2c2 = new MyTreeNode<String>("2.2");
				MyTreeNode<String> l2c3 = new MyTreeNode<String>("2.3");

				l1c1.addChild(l2c2);
				l1c1.addChild(l2c3);
			}
		}

		assertTrue(E1.isBalanced(root));
	}

	@Test
	public void testBalanced5() {
		MyTreeNode<String> root = new MyTreeNode<String>("ROOT");
		{
			MyTreeNode<String> l1c0 = new MyTreeNode<String>("1.0");
			root.addChild(l1c0);
		}

		assertTrue(E1.isBalanced(root));
	}
}
