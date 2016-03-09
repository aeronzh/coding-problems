package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Atul is into graph theory, and he is learning about trees nowadays. He observed that the removal of an edge from a given tree T will result in the formation of two separate trees, T1
 * and T2.
 * <p/>
 * Each vertex of the tree T is assigned a positive integer. Your task is to remove an edge, such that the Tree_diff of the resultant trees is minimized. Tree_diff is defined as the following:
 * <p/>
 * F(T) = Sum of numbers written on each vertex of a tree T
 * <p/>
 * Tree_diff(T) = abs(F(T1) - F(T2))
 * <p/>
 * <p/>
 * Input Format
 * The first line will contain an integer N, i.e. the number of vertices in the tree.
 * The next line will contain N integers separated by a single space, i.e. the values assigned to each of the vertices (where the first one is the root of the tree).
 * The next N−1 lines contain a pair of integers each, separated by a single space, that denote the edges of the tree.
 * In the above input, the vertices are numbered from 1 to N.
 * <p/>
 * Output Format
 * A single line containing the minimum value of Tree_diff.
 */
public class CutTheTree {
    static int[] subTreeSums;

    private static int sum(Integer node, Map<Integer, Set<Integer>> edges, int[] values) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[values.length];
        int sum = 0;
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            visited[currentNode - 1] = true;
            sum += values[currentNode - 1];
            if (edges.containsKey(currentNode)) {
                Set<Integer> neighbors = edges.get(currentNode);
                for (Integer neighbor : neighbors) {
                    if (!visited[neighbor - 1]) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return sum;
    }

    private static Set<Integer> reachSet(Integer node, Map<Integer, Set<Integer>> edges, Set<Integer> visited) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(node);
        visited.add(node);
        if (edges.containsKey(node)) {
            Set<Integer> neighbors = edges.get(node);
            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    set.addAll(reachSet(neighbor, edges, visited));
                }
            }
        }

        return set;
    }

    private static int brute(Map<Integer, Set<Integer>> edges, int[] values, List<Integer[]> edgePairs) {

        int min = Integer.MAX_VALUE;
        for (Integer[] pair : edgePairs) {
            int from = pair[0];
            int to = pair[1];
            edges.get(from).remove(to);
            edges.get(to).remove(from);
            int sumFrom = sum(from, edges, values);
            int sumTo = sum(to, edges, values);

            min = Math.min(min, Math.abs(sumTo - sumFrom));

            edges.get(from).add(to);
            edges.get(to).add(from);
        }

        return min;
    }

    //               1(100)
    //                  \
    //                2(200)
    //                 /   \
    //              (100)5  3(100)
    //                 / \
    //            (500)4 6(600)

    // Do dfs and store value[i] + sum of values of subtree of node i, for node i.
    //                1(1600)
    //                   \
    //                2(1500)
    //                 /    \
    //              (1200)5  3(100)
    //                 / \\
    //            (500)4 6(600)
    //
    // (value of max neighbor - edge to rem) - (edge to rem)
    // Cutting the edge at 1 2 would result in Tree_diff = 1500-100 = 1400
    // Cutting the edge at 2 3 would result in Tree_diff = 1500-100 = 1400
    // Cutting the edge at 2 5 would result in Tree_diff = 1200-400 = 800
    // Cutting the edge at 4 5 would result in Tree_diff = 1100-500 = 600
    // Cutting the edge at 5 6 would result in Tree_diff = 1000-600 = 400

    // Then search maximum value. Example 1600.

    // e.g. 5,6: got to the root (node 1). Subtract 600 (because we remove node 6). Now tree of node 1 has size 1000. And the tree
    // of node 6 has size 600. --> 1000 - 600 = 400

    private static int dfsSubtreeSum(Integer node, Map<Integer, Set<Integer>> edges, Set<Integer> visited, int[] values) {
        int sum = values[node - 1];
        visited.add(node);
        if (edges.containsKey(node)) {
            Set<Integer> neighbors = edges.get(node);
            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    sum += dfsSubtreeSum(neighbor, edges, visited, values);
                }
            }
        }

        subTreeSums[node - 1] = sum;
        return sum;
    }

    public static int solve(List<Integer[]> edgePairs) {
        int min = Integer.MAX_VALUE;
        for (Integer[] pair : edgePairs) {
            int from = pair[0];
            int to = pair[1];
            int root = subTreeSums[0] - subTreeSums[to - 1];
            min = Math.min(min, Math.abs(root - subTreeSums[to - 1]));
        }

        return min;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        Map<Integer, Set<Integer>> edges = new HashMap<Integer, Set<Integer>>();
        List<Integer[]> edgePairs = new ArrayList<Integer[]>();
        for (int i = 1; i < n; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            if (edges.containsKey(from)) {
                edges.get(from).add(to);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(to);
                edges.put(from, set);
            }

            if (edges.containsKey(to)) {
                edges.get(to).add(from);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(from);
                edges.put(to, set);
            }

            edgePairs.add(new Integer[]{from, to});
        }

        subTreeSums = new int[n];
        dfsSubtreeSum(1, edges, new HashSet<Integer>(), values);

        int min = solve(edgePairs);
        System.out.println(min);
    }
}
