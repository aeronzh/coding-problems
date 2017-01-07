package problems;

import java.util.*;

/**
 * https://lucaslouca.com/network-flow-problem-maximize-total-amount-of-flow-from-s-to-t/
 */
public class FordFulkerson {
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
            }
        }

        public void addEdge(T start, T dest, int cap) {
            nodeToNeighbors.get(start).add(dest);
            if (!capacity.containsKey(start)) {
                capacity.put(start, new HashMap<T, Integer>());
            }

            if (!residualCapacity.containsKey(start)) {
                residualCapacity.put(start, new HashMap<T, Integer>());
            }

            if (!residualCapacity.containsKey(dest)) {
                residualCapacity.put(dest, new HashMap<T, Integer>());
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

        OUTER:
        while (!queue.isEmpty()) {
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

            System.out.println("Found augmenting path '" + path + "' with bottleneck " + min);

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

    public static void main(String[] args) {
        DirectedGraph<String> graph = new DirectedGraph<String>();
        graph.addNode("s");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("t");

        graph.addEdge("s", "A", 10);
        graph.addEdge("s", "C", 10);
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("A", "D", 8);
        graph.addEdge("B", "t", 10);
        graph.addEdge("C", "D", 9);
        graph.addEdge("D", "B", 6);
        graph.addEdge("D", "t", 10);
        System.out.println("max flow = " + maxFlow(graph, "s", "t") + "\n"); // 19


        graph = new DirectedGraph<String>();
        graph.addNode("A"); // source
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "D", 3);
        graph.addEdge("B", "C", 4);
        graph.addEdge("C", "A", 3);
        graph.addEdge("C", "D", 1);
        graph.addEdge("C", "E", 2);
        graph.addEdge("D", "E", 2);
        graph.addEdge("D", "F", 6);
        graph.addEdge("E", "B", 1);
        graph.addEdge("E", "G", 1);
        graph.addEdge("F", "G", 9);
        System.out.println("max flow = " + maxFlow(graph, "A", "G") + "\n"); // 5

    }

}
