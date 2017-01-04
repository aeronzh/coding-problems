package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BikeRacers {

	private static class DirectedGraph<T> {
		private Map<T, Set<T>> nodeToNeighbors;
		private Map<T, Map<T, Integer>> capacity;
		private Map<T, Map<T, Integer>> residualCapacity;

		public DirectedGraph() {
			nodeToNeighbors = new HashMap<T, Set<T>>();
			capacity = new HashMap<T, Map<T, Integer>>();
			residualCapacity = new HashMap<T, Map<T, Integer>>();
		}

		public void addNode(T node) {
			if (!nodeToNeighbors.containsKey(node)) {
				nodeToNeighbors.put(node, new HashSet<T>());
				residualCapacity.put(node, new HashMap<T, Integer>());
			}
		}

		public void addEdge(T start, T dest, int cap) {
			nodeToNeighbors.get(start).add(dest);
			if (!capacity.containsKey(start)) {
				capacity.put(start, new HashMap<T, Integer>());
			}

			capacity.get(start).put(dest, cap);
			residualCapacity.get(start).put(dest, cap);
			residualCapacity.get(dest).put(start, 0);
		}

		public Set<T> getNodes() {
			return nodeToNeighbors.keySet();
		}

		public int getResidualCapacity(T start, T dest) {
			if (!residualCapacity.get(start).containsKey(dest)) {
				return 0;
			} else {
				return residualCapacity.get(start).get(dest);
			}
		}

		public void setResidualCapacity(T start, T dest, int f) {
			residualCapacity.get(start).put(dest, f);
		}
	}

	// Get BFS backtrack from source -> target
	private static Map<String, String> bfs(DirectedGraph<String> graph, String source, String target) {
		Map<String, String> backtrack = new HashMap<>();
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(source);

		OUTER: while (!queue.isEmpty()) {
			String node = queue.poll();
			visited.add(node);

			for (String n : graph.getNodes()) {
				if (!n.equals(node) && !visited.contains(n)) {
					if (graph.getResidualCapacity(node, n) > 0) {
						// We have a positive residual capacity to reach n from node
						queue.add(n);
						backtrack.put(n, node);
						if (n.equals(target)) {
							break OUTER;
						}
					}
				}
			}

		}

		return backtrack;
	}

	private static int maxFlow(DirectedGraph<String> graph, String source, String target) {
		int ans = 0;
		Map<String, String> backtrack = bfs(graph, source, target);
		List<String> path = new LinkedList<>();
		do {
			// Print augmenting path and also find the bottleneck of the path
			path.clear();
			path.add(target);
			String tail = target;
			int min = Integer.MAX_VALUE;
			while (backtrack.containsKey(tail)) {
				String prev = backtrack.get(tail);
				min = Math.min(min, graph.getResidualCapacity(prev, tail));
				path.add(0, prev);
				tail = prev;
			}

			if (path.size() <= 1) {
				break;
			}

			// Update residualCapacity
			tail = target;
			while (backtrack.containsKey(tail)) {
				String prev = backtrack.get(tail);
				// Decrement residual capacity for edge prev->tail
				graph.setResidualCapacity(prev, tail, graph.getResidualCapacity(prev, tail) - min);

				// Increase residual capacity for backwards edge tail->prev (i.e. open up an edge in the opposite direction)
				graph.setResidualCapacity(tail, prev, graph.getResidualCapacity(tail, prev) + min);

				tail = prev;
			}

			// Update max flow by min
			ans += min;

			// Repeat process: find a new path
			backtrack = bfs(graph, source, target);
		} while (path.size() > 1);

		return ans;
	}

	// Euclidean distance without square root
	private static BigInteger distance(int x1, int y1, int x2, int y2) {
		BigInteger x = new BigInteger("" + (x1 - x2));
		x = x.multiply(x);

		BigInteger y = new BigInteger("" + (y1 - y2));
		y = y.multiply(y);

		return x.add(y);
	}

	/**
	 * Make a bipartite graph, Having N node in one partite and having M nove in
	 * other partite and connect a node X from first partite to a node Y of
	 * second partite iff bike Y is reachable from biker X is given amount of
	 * time t
	 */
	private static DirectedGraph<String> createBipartiteGraph(int n, int m, int[][] bikers, int[][] bikes, Long t) {
		DirectedGraph<String> graph = new DirectedGraph<String>();

		// set source
		String source = "s";
		graph.addNode(source);

		// set target
		String target = "t";
		graph.addNode(target);

		for (int i = 0; i < n; i++) {
			for (int j = n; j < n + m; j++) {
				// Only connect bikers with bikes iff the bike is reachable by the biker in <= t time
				BigInteger distance = distance(bikers[i][0], bikers[i][1], bikes[j - n][0], bikes[j - n][1]);
				if (distance.compareTo(new BigInteger("" + t)) <= 0) {
					// add an edge
					String biker = "" + i;
					String bike = "" + j;
					graph.addNode(biker);
					graph.addNode(bike);
					graph.addEdge(biker, bike, 1);

					graph.addEdge(source, biker, 1);
					graph.addEdge(bike, target, 1);
				}
			}
		}

		return graph;
	}

	private static boolean check(int n, int m, int k, int[][] bikers, int[][] bikes, Long t) {
		DirectedGraph<String> graph = createBipartiteGraph(n, m, bikers, bikes, t);
		int maxFlow = maxFlow(graph, "s", "t");
		return maxFlow >= k;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		int[][] bikers = new int[n][2];
		for (int i = 0; i < n; i++) {
			bikers[i][0] = in.nextInt();
			bikers[i][1] = in.nextInt();
		}

		int[][] bikes = new int[m][2];
		for (int i = 0; i < m; i++) {
			bikes[i][0] = in.nextInt();
			bikes[i][1] = in.nextInt();
		}

		Long sqrLow = Long.parseUnsignedLong("0");
		Long sqrHigh = Long.parseUnsignedLong("100000000000000");
		while (sqrLow < sqrHigh) {
			long mid = (sqrLow + sqrHigh) / 2;
			if (check(n, m, k, bikers, bikes, mid)) {
				sqrHigh = mid;
			} else {
				sqrLow = mid + 1;
			}
		}

		System.out.println(sqrLow);
	}
}
