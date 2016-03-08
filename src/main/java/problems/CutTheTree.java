package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * Atul is into graph theory, and he is learning about trees nowadays. He
 * observed that the removal of an edge from a given tree T will result in the
 * formation of two separate trees, T1 and T2.
 * 
 * Each vertex of the tree T is assigned a positive integer. Your task is to
 * remove an edge, such that the Tree_diff of the resultant trees is minimized.
 * Tree_diff is defined as the following:
 * 
 * F(T) = Sum of numbers written on each vertex of a tree T Tree_diff(T) =
 * abs(F(T1) - F(T2))
 * 
 * 
 * Input Format
 * 
 * The first line will contain an integer N, i.e. the number of vertices in the
 * tree. The next line will contain N integers separated by a single space, i.e.
 * the values assigned to each of the vertices (where the first one is the root
 * of the tree). The next N−1 lines contain a pair of integers each, separated
 * by a single space, that denote the edges of the tree. In the above input, the
 * vertices are numbered from 1 to N.
 * 
 * 
 * 
 * Output Format
 * 
 * A single line containing the minimum value of Tree_diff.
 * 
 * @author lucas
 *
 */
public class CutTheTree {
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

	private static int solve(Map<Integer, Set<Integer>> edges, int[] values, List<Integer[]> edgePairs) {

		int min = Integer.MAX_VALUE;
		for (Integer[] pair : edgePairs) {
			int from = pair[0];
			int to = pair[1];
			//			System.out.println("Remove edge " + from + "--" + to);
			edges.get(from).remove(to);
			edges.get(to).remove(from);
			int sumFrom = sum(from, edges, values);
			int sumTo = sum(to, edges, values);

			//			System.out.println(from + " -> " + reachSet(from, edges, new HashSet<Integer>()) + "  sum= " + sumFrom);
			//			System.out.println(to + " -> " + reachSet(to, edges, new HashSet<Integer>()) + "  sum= " + sumTo);

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

	//               1(100)
	//                  \
	//                2(300)
	//                 /   \
	//              (400)5  3(400)
	//                 / \
	//            (900)4 6(1000)
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

			edgePairs.add(new Integer[] { from, to });
		}

		int min = solve(edges, values, edgePairs);
		System.out.println(min);

	}

}
