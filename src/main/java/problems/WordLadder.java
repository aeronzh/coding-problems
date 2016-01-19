package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary a transformation sequence
 * from start to end, such that only one letter can be changed at a time and
 * each intermediate word must exist in the dictionary. For example, given:
 * 
 * start = "hit", end = "cog", dict = ["hot","dot","dog","lot","log"]
 * 
 * One a transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * 
 * 
 * @author lucas
 *
 */
public class WordLadder {
	private static class Word {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((str == null) ? 0 : str.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Word other = (Word) obj;
			if (str == null) {
				if (other.str != null)
					return false;
			} else if (!str.equals(other.str))
				return false;
			return true;
		}

		public String str;
		public int steps;

		public String toString() {
			return str;
		}
	}

	private static class Graph<T> {
		private Map<T, List<T>> node2edges;

		public Graph() {
			node2edges = new HashMap<T, List<T>>();
		}

		private void addNode(T node) {
			if (!node2edges.containsKey(node)) {
				node2edges.put(node, new ArrayList());
			} else {
				throw new IllegalArgumentException("Node already exists!");
			}
		}

		private void addEdge(T start, T end) {
			if (!node2edges.containsKey(start)) {
				node2edges.put(start, new ArrayList(Arrays.asList(end)));
			} else {
				node2edges.get(start).add(end);
			}
		}

		private List<T> getNeighborsOf(T node) {
			if (!node2edges.containsKey(node)) {
				throw new IllegalArgumentException("Node doesn't exist!");
			} else {
				return node2edges.get(node);
			}
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (T node : node2edges.keySet()) {
				sb.append(node + " -> " + node2edges.get(node) + "\n");
			}

			return sb.toString();
		}
	}

	private static List<String> dictionary = new ArrayList(Arrays.asList("hot", "dot", "dog", "lot", "log"));;

	private static Map<String, List<Word>> buckets = new HashMap<String, List<Word>>();

	private static Graph<Word> graph;

	/**
	 * The bucket map contains a list of all words that differ by one character.
	 * Example for the key '_ot' it contains the list: [hot, dot, lot]
	 *
	 */
	private static void computeBuckets(String start, String end) {
		dictionary.add(start);
		dictionary.add(end);

		String temp;
		for (String str : dictionary) {
			int len = str.length();
			for (int i = 0; i < len; i++) {
				temp = str.substring(0, i) + "_" + str.substring(i + 1, len);
				Word word = new Word();
				word.str = str;
				if (buckets.containsKey(temp)) {
					buckets.get(temp).add(word);
				} else {
					buckets.put(temp, new ArrayList(Arrays.asList(word)));
				}
			}
		}
	}

	private static void constructGraph() {
		graph = new Graph<Word>();
		for (String key : buckets.keySet()) {
			List<Word> bucket = buckets.get(key);
			for (Word w1 : bucket) {
				for (Word w2 : bucket) {
					if (!w2.equals(w1)) {
						graph.addEdge(w1, w2);
					}
				}
			}
		}

	}

	private static void ladder(String start, String end) {
		computeBuckets(start, end);
		constructGraph();

		// Do a BFS
		boolean foundPath = false;
		Map<String, String> node2parent = new HashMap<String, String>();
		Queue<Word> queue = new LinkedList<Word>();
		Set<Word> visited = new HashSet<Word>();
		Word root = new Word();
		root.str = start;
		queue.add(root);
		while (!queue.isEmpty()) {
			Word node = queue.poll();
			visited.add(node);

			if (node.str.equals(end)) {
				foundPath = true;
				break;
			}

			for (Word neighbor : graph.getNeighborsOf(node)) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					node2parent.put(neighbor.str, node.str);
				}
			}
		}

		if (foundPath) {
			// Time to backtrack
			String node = end;
			String parent = node2parent.get(node);
			StringBuilder sb = new StringBuilder(node);
			while (parent != null) {
				sb.insert(0, parent + " -> ");
				node = parent;
				parent = node2parent.get(node);
			}

			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		ladder("hit", "cog");
	}
}
