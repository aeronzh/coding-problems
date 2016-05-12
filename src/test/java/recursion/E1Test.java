package recursion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exercises.recursion.E1;

public class E1Test {

	@Test
	public void testFibonacci1() {
		assertEquals(21, E1.fibonacci(8));
	}

	@Test
	public void testFibonacci2() {
		assertEquals(1, E1.fibonacci(1));
	}

	@Test
	public void testFibonacci3() {
		assertEquals(1, E1.fibonacci(2));
	}

	@Test
	public void testFibonacci4() {
		assertEquals(2, E1.fibonacci(3));
	}
}
