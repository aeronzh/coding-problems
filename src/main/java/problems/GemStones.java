package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a gem-element if it occurs at least once in each of the rocks.
 * <p/>
 * Given the list of N
 * <p/>
 * rocks with their compositions, display the number of gem-elements that exist in those rocks.
 * <p/>
 * Sample Input
 * <p/>
 * 3
 * abcdde
 * baccd
 * eeabg
 *
 *
 * Sample Output
 * <p/>
 * 2
 */
public class GemStones {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Character, Set<Integer>> map = new HashMap<Character, Set<Integer>>();
        for (int i = 0; i < n; i++) {
            char[] rock = scanner.next().toCharArray();
            boolean newRock = true;
            for (char c : rock) {
                if (!map.containsKey(c)) {
                    Set<Integer> set = new HashSet<Integer>();
                    set.add(i);
                    map.put(c, set);
                } else {
                    Set<Integer> set = map.get(c);
                    if (!set.contains(i)) {
                        set.add(i);
                        map.put(c, set);
                    }
                }
            }
        }

        int count = 0;
        for (Character c : map.keySet()) {
            Set<Integer> set = map.get(c);
            if (set.size() == n) {
                count++;
            }
        }

        System.out.println(count);
    }

}
