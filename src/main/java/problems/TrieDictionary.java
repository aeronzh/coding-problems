package problems;

import datastructures.Trie;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a stream of characters (e.g. acacabcatghhellomvnsdb) and a list of words (e.g. ["aca","cat","hello","world"] )
 * find and display count of each and every word once the stream ends.(Like : "aca" : 2 , "cat" : 1 , "hello" : 1 ,
 * "world" : 0 ).
 */
public class TrieDictionary {
    static Map<String, StringBuilder> buffers;
    static Map<String, Integer> ans;

    private static void processCharacter(char c) {
        for (String word : buffers.keySet()) {
            buffers.get(word).append(c);
            if (buffers.get(word).toString().equals(word)) {
                ans.put(word, ans.get(word) + 1);
            }

            if (buffers.get(word).length() == word.length()) {
                buffers.get(word).deleteCharAt(0);
            }
        }
    }


    public static void main(String[] args) {
        String[] dict = {"aca", "cat", "hello", "world"};
        String stream = "acacabcatghhellomvnsdb";

        buffers = new HashMap<>();
        ans = new HashMap<>();
        for (String word : dict) {
            buffers.put(word, new StringBuilder());
            ans.put(word, 0);
        }

        // Read stream
        for (char c : stream.toCharArray()) {
            processCharacter(c);
        }

        System.out.println(buffers);
        System.out.println(ans);
    }
}
