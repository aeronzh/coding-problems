package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by lucas on 24/12/2016.
 */
public class GroupAnagrams {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        Map<String, Set<String>> map = new HashMap<>();
        while (in.hasNext()) {
            String word = in.nextLine();
            int[] keyArr = new int[26];
            for (char c : word.replaceAll(" ", "").toCharArray()) {
                keyArr[c - 'a'] = keyArr[c - 'a'] + 1;
            }
            String key = Arrays.toString(keyArr);

            if (!map.containsKey(key)) {
                map.put(key, new TreeSet<>());
            }

            map.get(key).add(word);
        }

        for (String key : map.keySet()) {
            String out = map.get(key).toString();
            System.out.println(out.substring(1, out.length() - 1));
        }
    }
}