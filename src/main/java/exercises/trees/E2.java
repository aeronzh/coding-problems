package exercises.trees;

import java.util.HashSet;
import java.util.Set;

import datastructures.MyDirectedGraph;

/**
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * 
 * @author lucas
 *
 */
public class E2 {

	private static <T> boolean doesRouteExist(T current, T dest, Set<T> visited, MyDirectedGraph<T> graph) {
		visited.add(current);
		if (current.equals(dest)) {
			return true;
		} else {
			boolean found = false;
			for (T neighbor : graph.getNeighbors(current)) {
				if (!visited.contains(neighbor)) {
					found = doesRouteExist(neighbor, dest, visited, graph);
					if (found) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * Given a directed graph, checks whether there is a route between two
	 * nodes.
	 * 
	 * @param current
	 * @param dest
	 * @param visited
	 * @param graph
	 * @return true if a route exists. Returns false otherwise.
	 */
	public static <T> boolean doesRouteExist(T current, T dest, MyDirectedGraph<T> graph) {
		return doesRouteExist(current, dest, new HashSet<T>(), graph);
	}

	public static void main(String[] args) {
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

		System.out.println(doesRouteExist(1, 10, new HashSet<Integer>(), graph));
	}

}
