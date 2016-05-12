package exercises.trees;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class E3Test {

	@Test
	public void testTree1() {
		assertEquals("[4->[2->[1][3]][6->[5][7]]]", E3.createBinaryTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }).toString());
	}
}
