package exercises.trees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datastructures.MyDirectedGraph;

public class E2Test {

	@Test
	public void testHasRoute1() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(6, 10);

		assertTrue(E2.doesRouteExist(1, 10, graph));
	}

	@Test
	public void testHasRoute2() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(6, 10);

		assertTrue(E2.doesRouteExist(1, 1, graph));
	}

	@Test
	public void testHasRoute3() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(6, 10);

		assertTrue(E2.doesRouteExist(1, 3, graph));
	}

	@Test
	public void testHasRoute4() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(6, 10);

		assertTrue(E2.doesRouteExist(1, 7, graph));
	}

	@Test
	public void testHasRoute5() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(6, 10);

		assertTrue(E2.doesRouteExist(1, 8, graph));
	}

	@Test
	public void testHasRoute6() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(6, 10);

		assertTrue(E2.doesRouteExist(1, 9, graph));
	}

	@Test
	public void testHasRoute7() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(6, 10);

		assertTrue(E2.doesRouteExist(1, 10, graph));
	}

	@Test
	public void testHasRoute8() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(6, 10);

		assertFalse(E2.doesRouteExist(10, 1, graph));
	}

	@Test
	public void testHasRoute9() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(6, 10);

		assertFalse(E2.doesRouteExist(3, 2, graph));
	}

	@Test
	public void testHasRoute10() {
		MyDirectedGraph<Integer> graph = new MyDirectedGraph<Integer>();
		for (int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}

		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(6, 10);

		assertTrue(E2.doesRouteExist(2, 8, graph));
	}
}
