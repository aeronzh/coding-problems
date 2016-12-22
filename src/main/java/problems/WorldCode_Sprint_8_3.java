package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class WorldCode_Sprint_8_3 {

    /**
     * Returns a List of clusters in the graph.
     * @param n
     * @param graph
     * @return
     */
    @Deprecated
private static List<Set<Integer>> cluster(int n, Map<Integer, Set<Integer>> graph) {
    boolean[] visited = new boolean[n + 1];
    List<Set<Integer>> clusters = new ArrayList<>();

    for (int node = 1; node <= n; node++) {
        if (!visited[node]) {
            // Start an new cluster
            Set<Integer> cluster = new HashSet<>();

            // Do BFS
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(node);

            while (!queue.isEmpty()) {
                Integer root = queue.poll();

                // Add node to cluster
                cluster.add(root);

                // Mark node as visited
                visited[root] = true;


                Set<Integer> neighbors = graph.get(root);
                for (Integer adj : neighbors) {
                    if (!visited[adj]) {
                        queue.add(adj);
                    }
                }

            }

            if (!cluster.isEmpty()) {
                clusters.add(cluster);
            }
        }
    }

    return clusters;
}


    private static long dfs(int root, Map<Integer, Set<Integer>> graph, boolean[] visited, long count) {
        visited[root] = true;

        Set<Integer> neighbors = graph.get(root);
        for (Integer adj : neighbors) {
            if (!visited[adj]) {
                count = 1 + dfs(adj, graph, visited, count);
            }
        }

        return count;
    }

    private static long solve(int n, int m, long clib, long croad, Map<Integer, Set<Integer>> graph) {
        long ans = 0;

        boolean[] visited = new boolean[n + 1];
        for (int node = 1; node <= n; node++) {
            if (!visited[node]) {
                long clusterSize = dfs(node, graph, visited, 1);

                ans += clib;
                if (clib > croad) {
                    ans += ((clusterSize - 1) * croad);
                } else {
                    ans += ((clusterSize - 1) * clib);
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int tests = in.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = in.nextInt(); // number of cities
            int m = in.nextInt(); // number of roads
            long clib = in.nextLong();
            long croad = in.nextLong(); // number of roads

            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int node = 1; node <= n; node++) {
                graph.put(node, new HashSet<>());
            }

            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            System.out.println(solve(n, m, clib, croad, graph));
        }
    }
}
