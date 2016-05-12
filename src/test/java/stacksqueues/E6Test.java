package stacksqueues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datastructures.IStack;
import datastructures.MyStack;

public class E6Test {

	@Test
	public void testSort1() {
		IStack<Integer> stack = new MyStack<Integer>();
		stack.push(10);
		stack.push(1);
		stack.push(0);
		stack.push(110);
		stack.push(-1);
		stack.push(5);

		IStack<Integer> sortedStack = E6.sortStack(stack);
		assertEquals("[-1, 0, 1, 5, 10, 110", sortedStack.toString());
	}

	@Test
	public void testSort2() {
		IStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);

		IStack<Integer> sortedStack = E6.sortStack(stack);
		assertEquals("[1, 1, 1, 1, 1", sortedStack.toString());
	}

	@Test
	public void testSort3() {
		IStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		IStack<Integer> sortedStack = E6.sortStack(stack);
		assertEquals("[1, 2, 3, 4, 5", sortedStack.toString());
	}

	@Test
	public void testSort4() {
		IStack<Integer> stack = new MyStack<Integer>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		IStack<Integer> sortedStack = E6.sortStack(stack);
		assertEquals("[1, 2, 3, 4", sortedStack.toString());
	}

	@Test
	public void testSort5() {
		IStack<Integer> stack = new MyStack<Integer>();
		IStack<Integer> sortedStack = E6.sortStack(stack);
		assertEquals("[", sortedStack.toString());
	}
}
