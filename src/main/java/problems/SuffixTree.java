package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucas on 29/02/16.
 */
public class SuffixTree {

    private class SuffixTreeNode {
        SuffixTreeNode suffixLink;
        Map<Character, SuffixTreeNode> children;

        public SuffixTreeNode() {
            this.suffixLink = this;
            this.children = new HashMap<Character, SuffixTreeNode>();
        }

        public SuffixTreeNode(SuffixTreeNode suffixLink) {
            this();
            this.suffixLink = suffixLink;
        }

        public void addChild(Character c, SuffixTreeNode child) {
            this.children.put(c, child);
        }

        public boolean containsSubstring(String str) {
            if (str.length() == 0) {
                return true;
            } else {
                if (this.children.containsKey(str.charAt(0))) {
                    SuffixTreeNode next = this.children.get(str.charAt(0));
                    return next.containsSubstring(str.substring(1));
                } else {
                    return false;
                }
            }
        }

        public boolean containsSuffix(String str) {
            if (str.length() == 0) {
                return this.children.isEmpty();
            } else {
                if (this.children.containsKey(str.charAt(0))) {
                    SuffixTreeNode next = this.children.get(str.charAt(0));
                    return next.containsSuffix(str.substring(1));
                } else {
                    return false;
                }
            }
        }
    }

    SuffixTreeNode root;

    public SuffixTree(String str) {
        if (str.length() > 0) {
            construct(str);
        }
    }

    private void construct(String str) {
        this.root = new SuffixTreeNode();
        SuffixTreeNode longest = new SuffixTreeNode(root);
        root.addChild(str.charAt(0), longest);

        // Add rest of the characters
        for (int i = 1; i < str.length(); i++) {
            Character c = str.charAt(i);
            SuffixTreeNode current = longest;
            SuffixTreeNode previous = null;

            while (!current.children.containsKey(c)) {
                SuffixTreeNode newNode = new SuffixTreeNode();
                current.addChild(c, newNode);

                if (previous != null) {
                    previous.suffixLink = newNode;
                }

                previous = newNode;

                // Got to next shortest suffix
                current = current.suffixLink;
            }

            // If we reached the root
            if (current == root) {
                previous.suffixLink = root;
            } else {
                previous.suffixLink = current.children.get(c);
            }

            // Move to the end of the longest suffix (which is the newly added character to the existing longest suffix)
            longest = longest.children.get(c);
        }
    }

    public boolean containsSubstring(String str) {
        return this.root.containsSubstring(str);
    }

    public boolean containsSuffix(String str) {
        return this.root.containsSuffix(str);
    }

    public static void main(String[] args) {
        SuffixTree tree = new SuffixTree("ababax");
        System.out.println(tree.containsSuffix("bax"));

    }
}