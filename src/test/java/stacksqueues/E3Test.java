package stacksqueues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stacksqueues.E3.SetOfStacks;

public class E3Test {

	@Test
	public void testPop1() {
		SetOfStacks<Integer> stackSet = new SetOfStacks<Integer>(3);
		for (int i = 1; i <= 10; i++) {
			stackSet.push(i);
		}

		for (int i = 1; i <= 7; i++) {
			stackSet.pop();
		}

		assertEquals(new Integer(3), stackSet.pop());
	}

	@Test
	public void testPop2() {
		SetOfStacks<Integer> stackSet = new SetOfStacks<Integer>(3);
		stackSet.push(1);
		assertEquals(new Integer(1), stackSet.pop());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testException1() {
		SetOfStacks<Integer> stackSet = new SetOfStacks<Integer>(3);
		stackSet.pop();
	}

	@Test
	public void testNumberOfStacks1() {
		SetOfStacks<Integer> stackSet = new SetOfStacks<Integer>(3);
		for (int i = 1; i <= 10; i++) {
			stackSet.push(i);
		}

		for (int i = 1; i <= 7; i++) {
			stackSet.pop();
		}

		assertEquals(1, stackSet.getNumberOfStacks());
	}

	@Test
	public void testNumberOfStacks2() {
		SetOfStacks<Integer> stackSet = new SetOfStacks<Integer>(3);
		for (int i = 1; i <= 10; i++) {
			stackSet.push(i);
		}

		for (int i = 1; i <= 6; i++) {
			stackSet.pop();
		}

		assertEquals(2, stackSet.getNumberOfStacks());
	}
}
