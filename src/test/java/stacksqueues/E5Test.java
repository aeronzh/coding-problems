package stacksqueues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datastructures.IQueue;
import stacksqueues.E5.MyQueue;

public class E5Test {

	@Test
	public void testDequeue1() {
		IQueue<Integer> queue = new MyQueue<Integer>();
		for (int i = 1; i <= 10; i++) {
			queue.enqueue(i);
		}

		assertEquals(new Integer(1), queue.dequeue());

	}

	@Test
	public void testDequeue2() {
		IQueue<Integer> queue = new MyQueue<Integer>();
		for (int i = 1; i <= 10; i++) {
			queue.enqueue(i);
		}

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		assertEquals(new Integer(4), queue.dequeue());
	}

}
