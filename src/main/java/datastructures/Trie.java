package datastructures;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	int words;
	int prefixes;
	Map<Character, Trie> edges;

	public Trie() {
		words = 0;
		prefixes = 0;
		edges = new HashMap<Character, Trie>();
	}

	public void addWord(String word) {
		if (word.isEmpty()) {
			words++;
		} else {
			prefixes++;
			Character firstChar = word.charAt(0);

			if (!edges.containsKey(firstChar)) {
				edges.put(firstChar, new Trie());
			}

			edges.get(firstChar).addWord(word.substring(1, word.length()));
		}
	}

	public int countPrefixes(String prefix) {
		if (prefix.isEmpty()) {
			return prefixes;
		} else {
			Character firstChar = prefix.charAt(0);
			if (!edges.containsKey(firstChar)) {
				return 0;
			} else {
				return edges.get(firstChar).countPrefixes(prefix.substring(1, prefix.length()));
			}
		}
	}

	public int countWords(String word) {
		if (word.isEmpty()) {
			return words;
		} else {
			Character firstChar = word.charAt(0);
			if (!edges.containsKey(firstChar)) {
				return 0;
			} else {
				return edges.get(firstChar).countWords(word.substring(1, word.length()));
			}
		}
	}

	public void wordsWithPrefix(String prefix, String found) {
		if (prefix.isEmpty()) {
			// empty, print all words
			for (Character key : edges.keySet()) {
				edges.get(key).wordsWithPrefix("", found + key);
			}
			
			if (edges.keySet().isEmpty()) {
				System.out.println(found);
			}

		} else {
			Character firstChar = prefix.charAt(0);
			if (edges.containsKey(firstChar)) {
				edges.get(firstChar).wordsWithPrefix(prefix.substring(1, prefix.length()), found);
			}

		}
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.addWord("tree");
		t.addWord("trie");
		t.addWord("algorithm");
		t.addWord("assoc");
		t.addWord("all");
		t.addWord("also");
		t.addWord("al");

		t.wordsWithPrefix("al", "al");
	}

}
