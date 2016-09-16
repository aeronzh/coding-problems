package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GravityTree {

	private static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	private static void gen() {
		String str = "1";
		int n = 100000;
		for (int i = 1; i <= n - 1; i++) {
			int num = random(1, n);
			str = str + " " + num;
		}

		try {
			PrintWriter writer = new PrintWriter(System.getProperty("user.home") + "/" + "test-string.txt", "UTF-8");
			writer.println(str);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(str);

	}

	private static class LLDirectedGraph {

		/**
		 * Internal Graph Node model never exposed to the public. Wrapper class
		 * containing properties for shortest path computation, etc.
		 */
		private class GraphNode {
			private Integer data;
			protected Map<Integer, Integer> neighbours;

			public GraphNode(Integer data) {
				this.data = data;
				this.neighbours = new HashMap<Integer, Integer>();
			}

			public Map<Integer, Integer> getNeighbours() {
				return neighbours;
			}

			@Override
			public String toString() {
				return data.toString();
			}
		}


		private Map<Integer, GraphNode> graph;

		public LLDirectedGraph() {
			graph = new HashMap<Integer, GraphNode>();
		}

		public void addNode(Integer node) {
			GraphNode graphNode = new GraphNode(node);
			if (!graph.containsKey(node)) {
				graph.put(node, graphNode);
			}
		}

		public void addEdge(Integer start, Integer dest, int weight) {
			if (weight < 0) {
				throw new IllegalArgumentException("Weight must be >= 0");
			}

			graph.get(start).getNeighbours().put(dest, weight);
		}

		public Set<Integer> getNeighbours(Integer node) {
			return graph.get(node).getNeighbours().keySet();
		}

		public Set<Integer> getNodes() {
			return graph.keySet();
		}

		private void subTreeOf(int root, Set<Integer> visited, int[] a) {
			visited.add(root);
			
			Set<Integer> neighbours = getNeighbours(root);
			for (Integer neighbour : neighbours) {
				if (!visited.contains(neighbour) && a[neighbour-1]==root) {
					subTreeOf(neighbour, visited, a);
				}
			}
		}
		
		private long dfs(Integer currentNode, Integer targetNode, Set<Integer> visited) {
			visited.add(currentNode);

			if (currentNode.equals(targetNode)) {
				return 0;
			} else {

				Set<Integer> neighbours = getNeighbours(currentNode);
				for (Integer neighbour : neighbours) {
					if (!visited.contains(neighbour)) {
						long result = dfs(neighbour, targetNode, visited);
						if (result != -1) {
							return result + 1;
						}
					}
				}

				return -1;
			}
		}

	}

	private static void solve(long[] dist, int u, int turnedOnVertex, LLDirectedGraph graph, int[] a) {
		//System.out.println("Distance from " + u + " to " + turnedOnVertex + " = " + Math.abs(dist[u] - dist[turnedOnVertex]));
		Set<Integer> subTree = new HashSet<Integer>();
		graph.subTreeOf(turnedOnVertex, subTree, a);
		long total = 0;
		for (int n:subTree) {
			long d = Math.abs(dist[u] - dist[n]);
			total += (d*d);
		}
		
		System.out.println(total);
	}

	/**
	 * (i+1)th node has parent A[i] and node 1 is always the root.
	 * 
	 * i+1 : 2 3 4 5
	 * 
	 * A[i] : 1 2 2 4
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		LLDirectedGraph graph = new LLDirectedGraph();

		int n = in.nextInt();
		int[] a = new int[n+1];
		
		graph.addNode(1);
		for (int child = 2; child <= n; child++) {
			int parent = in.nextInt();
			graph.addNode(parent);
			graph.addNode(child);

			//System.out.println(i + " is child of " + v);
			graph.addEdge(child, parent, 1);
			graph.addEdge(parent, child, 1);
			
			a[child-1] = parent;
		}

		// Compute distance from other nodes
		long[] dist = new long[n + 1]; // dist[i] = distance from root to i
		for (int i = 2; i <= n; i++) {
			dist[i] = graph.dfs(1, i, new HashSet<Integer>());
		}

		int queries = in.nextInt();

		for (int q = 0; q < queries; q++) {
			int u = in.nextInt();
			int turnedOnVertex = in.nextInt();
			solve(dist, u, turnedOnVertex, graph, a);
		}

	}

}
