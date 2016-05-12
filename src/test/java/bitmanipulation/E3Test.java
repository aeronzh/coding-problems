package bitmanipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exercises.bitmanipulation.E3;

public class E3Test {

	@Test
	public void testSmallest1() {
		assertEquals(33, E3.findSmallest(34));
	}

	@Test
	public void testSmallest2() {
		assertEquals(8, E3.findSmallest(16));
	}

	@Test
	public void testLargest1() {
		assertEquals(36, E3.findLargest(34));
	}

	@Test
	public void testLargest2() {
		assertEquals(32, E3.findLargest(16));
	}
}
