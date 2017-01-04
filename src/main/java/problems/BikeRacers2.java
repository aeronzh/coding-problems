package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BikeRacers2 {
	// Return true if a path s->....->t exists
	private static boolean bfs(int residualCapacity[][], int source, int target, int parent[]) {
		int n = residualCapacity.length;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);

		// Mark source as visited
		visited[source] = true;

		parent[source] = -1;

		BFS: while (queue.size() != 0) {
			int node = queue.poll();
			for (int v = 0; v < n; v++) {
				if (!visited[v] && residualCapacity[node][v] > 0) {
					visited[v] = true;
					parent[v] = node;
					queue.add(v);
					if (visited[target]) {
						break BFS;
					}
				}
			}
		}

		return (visited[target] == true);
	}

	private static boolean dfs(int residualCapacity[][], int source, int target, int parent[], boolean[] visited) {
		int n = residualCapacity.length;
		visited[source] = true;

		if (visited[target]) {
			return true;
		} else {
			for (int v = 0; v < n; v++) {
				if (!visited[v] && residualCapacity[source][v] > 0) {
					visited[v] = true;
					parent[v] = source;
					dfs(residualCapacity, v, target, parent, visited);
				}
			}

		}
		return (visited[target] == true);
	}

	private static int maxFlow(int graph[][], int source, int target) {
		int n = graph.length;
		int[][] residualCapacity = new int[n][n];

		for (int u = 0; u < n; u++) {
			for (int v = 0; v < n; v++) {
				residualCapacity[u][v] = graph[u][v];
			}
		}

		// For backtracking
		int[] parent = new int[n];

		// Initially flow is 0
		int flow = 0;

		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}
		
		while (dfs(residualCapacity, source, target, parent, new boolean[n])) {
			// Find the bottleneck (minimum residual capacity) of path
			int bottleneck = Integer.MAX_VALUE;
			for (int v = target; v != source; v = parent[v]) {
				int u = parent[v];
				bottleneck = Math.min(bottleneck, residualCapacity[u][v]);
			}

			// Augment edges
			for (int v = target; v != source; v = parent[v]) {
				int u = parent[v];
				residualCapacity[u][v] -= bottleneck;
				residualCapacity[v][u] += bottleneck;
			}

			// Update max flow
			flow += bottleneck;
		}

		return flow;
	}

	// Euclidean distance without square root
	private static BigInteger distance(int x1, int y1, int x2, int y2) {
		BigInteger x = new BigInteger("" + (x1 - x2));
		x = x.multiply(x);

		BigInteger y = new BigInteger("" + (y1 - y2));
		y = y.multiply(y);

		return x.add(y);
	}

	// Check if there is a maxFlow >= k in a bipartite graph created 
	// by connecting bikers with bikes iff the bike is reachable by 
	// the biker in <= sqrt(t) time
	private static boolean check(int n, int m, int k, int[][] bikers, int[][] bikes, BigInteger t, BigInteger[][] dist) {
		// Build a bipartite graph by connecting bikers with bikes iff the bike is reachable by the biker in <= t time.

		// Choose some unique integer for source and target
		int source = n + m;
		int target = n + m + 1;

		int graph[][] = new int[n + m + 2][n + m + 2];
		for (int biker = 0; biker < n; biker++) {
			for (int bike = n; bike < n + m; bike++) {
				// Only connect bikers with bikes iff the bike is reachable by the biker in <= t time
				if (dist[biker][bike].compareTo(t) <= 0) {
					// Add an edge with capacity 1
					graph[biker][bike] = 1;

					// Add edge source->biker
					graph[source][biker] = 1;

					// Add edge bike->target
					graph[bike][target] = 1;
				}
			}
		}

		return maxFlow(graph, source, target) >= k;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		// Read input
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

		BigInteger[][] dist = new BigInteger[n+m+2][n+m+2];
		for (int biker = 0; biker < n; biker++) {
			for (int bike = n; bike < n + m; bike++) {
				// Only connect bikers with bikes iff the bike is reachable by the biker in <= t time
				BigInteger distance = distance(bikers[biker][0], bikers[biker][1], bikes[bike - n][0], bikes[bike - n][1]);
				dist[biker][bike] = distance;
			}
		}
		
		// Standard binary search loop
		Long sqrLow = Long.parseUnsignedLong("0");
		Long sqrHigh = Long.parseUnsignedLong("10000000000000000");
		while (sqrLow < sqrHigh) {
			long mid = (sqrLow + sqrHigh) / 2;
			if (check(n, m, k, bikers, bikes, new BigInteger("" + mid), dist)) {
				sqrHigh = mid;
			} else {
				sqrLow = mid + 1;
			}
		}

		System.out.println(sqrLow);
	}
}
