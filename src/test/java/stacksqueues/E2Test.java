package stacksqueues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stacksqueues.E2.MyStackWithMin;

public class E2Test {

	@Test
	public void testMin1() {
		MyStackWithMin<Integer> stack = new MyStackWithMin<Integer>();
		stack.push(10);
		stack.push(1);
		stack.push(0);
		stack.push(110);
		stack.push(-1);
		stack.push(5);

		assertEquals(new Integer(-1), stack.min());
	}

	@Test
	public void testMin2() {
		MyStackWithMin<Integer> stack = new MyStackWithMin<Integer>();
		stack.push(10);
		stack.push(1);
		stack.push(0);
		stack.push(110);
		stack.push(-1);
		stack.push(5);

		stack.pop();
		stack.pop();

		assertEquals(new Integer(0), stack.min());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMin3() {
		MyStackWithMin<Integer> stack = new MyStackWithMin<Integer>();
		stack.min();
	}
}
