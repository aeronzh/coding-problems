package problems;

import java.util.LinkedList;
import java.util.Queue;

public class AhoCorasick {

    static class TrieNode {
        private final int SIZE = 4;

        TrieNode parent;
        TrieNode fall;
        TrieNode[] children;
        char c;
        TrieNode next;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[SIZE];
        }

        public TrieNode(char c) {
            this();
            this.c = c;
        }

        public TrieNode child(char ch) {
            TrieNode node = children[ch % SIZE];
            if (node == null) {
                return null;
            } else {
                while (node.next != null) {
                    if (node.c == ch) {
                        return node;
                    }
                    node = node.next;
                }

                // Char was at end of list
                if (node.c == ch) {
                    return node;
                }

                return null;
            }
        }

        public void addWord(String word) {
            char firstChar = word.charAt(0);
            TrieNode child = child(firstChar);
            if (child == null) {
                child = new TrieNode(firstChar);
                child.parent = this;
                int pos = firstChar % SIZE;
                if (children[pos] == null) {
                    children[pos] = child;
                } else {
                    TrieNode node = children[pos];
                    while (node.next != null) {
                        node = node.next;
                    }

                    node.next = child;
                }
            }

            if (word.length() > 1) {
                child.addWord(word.substring(1));
            } else {
                child.isEnd = true;
            }
        }

        public boolean contains(String word) {
            if (word.length() == 0) {
                return isEnd;
            } else {
                TrieNode node = child(word.charAt(0));
                if (node == null) {
                    return false;
                } else {
                    return node.contains(word.substring(1));
                }
            }
        }

        public void constructFallLinks() {
            TrieNode root = this;
            root.fall = root;

            // BFS
            Queue<TrieNode> queue = new LinkedList<TrieNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TrieNode currentNode = queue.poll();

                // Add children
                for (int i = 0; i < SIZE; i++) {
                    TrieNode node = currentNode.children[i];
                    if (node != null) {
                        while (node.next != null) {
                            queue.add(node);
                            node = node.next;
                        }
                        queue.add(node);
                    }
                }

                if (currentNode != root) {
                    // Traverse up the parent's fall to find the longest suffix or until we reach root of the tree
                    TrieNode f = currentNode.parent.fall;
                    while (f.child(currentNode.c) != null && f != root) {
                        f = f.fall;
                    }

                    currentNode.fall = f.child(currentNode.c);

                    if (currentNode.fall == null) {
                        // No suffix found. Point fall to root.
                        currentNode.fall = root;
                    }

                    if (currentNode.fall == currentNode) {
                        currentNode.fall = root;
                    }

                }
            }
        }


        /**
         * Performs a search on text for the words contained in the Trie
         *
         * @param text
         */
        public void search(String text) {
            TrieNode root = this;
            TrieNode currentNode = root;
            TrieNode node;
            TrieNode n;
            char[] chars = text.toCharArray();

            for (char ch : chars) {
                node = currentNode;

                // Move on falls until we find the right child or reach the root
                while (node.child(ch) == null && node != root) {
                    node = node.fall;
                }

                if (node == root) {
                    node = node.child(ch);
                    if (node == null) {
                        node = root;
                    }
                } else {
                    node = node.child(ch);
                }

                n = node;
                while (n != root) {
                    if (n.isEnd) {
                        System.out.println("Found word that ends at " + n.c);
                    }
                    n = n.fall;
                }

                currentNode = node;
            }
        }
    }

    public static void main(String[] args) {
        TrieNode trie = new TrieNode();

        trie.addWord("2");
        trie.addWord("4");
        trie.addWord("256");

        trie.constructFallLinks();
        trie.search("24256");
    }

}
