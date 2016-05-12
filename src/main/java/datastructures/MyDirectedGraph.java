package datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class MyDirectedGraph<T> {
	private Map<T, Set<T>> nodeToNeighbors;

	public MyDirectedGraph() {
		nodeToNeighbors = new HashMap<T, Set<T>>();
	}

	/**
	 * Add a new node to the graph.
	 * 
	 * @param node
	 *            the new node to add to the graph
	 */
	public void addNode(T node) {
		if (!nodeToNeighbors.containsKey(node)) {
			nodeToNeighbors.put(node, new HashSet<T>());
		}
	}

	/**
	 * Add an unidirectional edge from a given start node to a destination node.
	 * 
	 * @param start
	 *            the node with outgoing edge
	 * @param dest
	 *            the node with the incoming edge
	 * 
	 * @throws NoSuchElementException
	 *             if one or both nodes don't exist
	 */
	public void addEdge(T start, T dest) {
		if (!nodeToNeighbors.containsKey(start) || !nodeToNeighbors.containsKey(dest)) {
			throw new NoSuchElementException("Both nodes must be contained in the graph!");
		} else {
			nodeToNeighbors.get(start).add(dest);
		}
	}

	/**
	 * Remove an edge from the graph.
	 * 
	 * @param start
	 *            the node with outgoing edge
	 * @param dest
	 *            the node with the incoming edge
	 * @throws NoSuchElementException
	 *             if one or both nodes don't exist
	 */
	public void removeEdge(T start, T dest) {
		if (!nodeToNeighbors.containsKey(start) || !nodeToNeighbors.containsKey(dest)) {
			throw new NoSuchElementException("Both nodes must be contained in the graph!");
		} else {
			nodeToNeighbors.get(start).remove(dest);
		}
	}

	/**
	 * Get all the adjacent nodes of the given node.
	 * 
	 * @param node
	 *            the node to retrieve the neighbors from
	 * @return Set of neighbors
	 * @throws NoSuchElementException
	 *             if node doesn't exist
	 */
	public Set<T> getNeighbors(T node) {
		if (!nodeToNeighbors.containsKey(node)) {
			throw new NoSuchElementException("Node doesn't exist!");
		} else {
			return nodeToNeighbors.get(node);
		}
	}

	/**
	 * Given two nodes in the graph, returns whether there is an edge from the
	 * first node to the second node. If either node does not exist in the
	 * graph, throws a NoSuchElementException.
	 * 
	 * @param start
	 *            The start node.
	 * @param end
	 *            The destination node.
	 * @return Whether there is an edge from start to end.
	 * @throws NoSuchElementException
	 *             If either endpoint does not exist.
	 */
	public boolean edgeExists(T start, T dest) {
		/* Confirm both endpoints exist. */
		if (!nodeToNeighbors.containsKey(start) || !nodeToNeighbors.containsKey(dest))
			throw new NoSuchElementException("Both nodes must be in the graph.");

		return nodeToNeighbors.get(start).contains(dest);
	}
}
