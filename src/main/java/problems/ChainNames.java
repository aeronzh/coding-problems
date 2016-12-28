package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The input is a list of names in random order. We need a function that chains elements of the list in such a way that
 * the last character of an name is the same as the first one of the next name.
 * <p>
 * For instance:
 * <p>
 * Input: [“Raymond”, “Nora”, “Daniel”, “Louie”, “Peter”, “Esteban”]
 * <p>
 * Output: [“Peter”, “Raymond”, “Daniel”, “Louie”, “Esteban”, “Nora”]
 * <p>
 * All names should be used. It is guaranteed that each name starts with a unique letter. It is also guaranteed that
 * there is only one solution.
 */
public class ChainNames {

    private static String[] chainNames0(String[] N) {
        for (String s : N) {
            System.out.println("s = " + s);
            for (int i = 0; i < N.length; i++) {
                if (!s.contains(N[i]) && s.toUpperCase().charAt(s.length() - 1) == N[i].charAt(0)) {
                    s = s + " " + N[i];
                    System.out.println("  chain = " + s);
                    if (s.split(" ").length == N.length) {
                        return s.split(" ");
                    }

                    // Since we have updated our s, we need to restart the inner loop by setting i=-1.
                    i = -1;
                }
            }
        }

        return N;
    }

    private static String[] chainNames1(String[] names) {

        // Find the first name to put in the chain.
        // Whose first letter of name is not end letter of anybody's name.
        Map<Character, String> f = new HashMap<>();
        Map<Character, String> l = new HashMap<>();
        List<String> nl = new ArrayList<>();

        for (String e : names) {
            f.put(Character.toLowerCase(e.charAt(0)), e);
            l.put(e.charAt(e.length() - 1), e);
        }

        String a = "";
        Iterator<Map.Entry<Character, String>> i = f.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<Character, String> n = i.next();
            String p = l.get(n.getKey());
            if (p == null) {
                // this will be the first name.
                a = n.getValue();
                nl.add(a);
                String b = f.get(a.charAt(a.length() - 1));
                while (b != null) {
                    nl.add(b);
                    a = b;
                    b = f.get(a.charAt(a.length() - 1));
                }

                break;
            }
        }

        return nl.toArray(new String[0]);

    }

    private static String[] chainNames(String[] names) {
        Map<Character, String> first = new HashMap<>();
        Set<Character> last = new HashSet<>();
        for (String name : names) {
            char ch = name.charAt(0);
            first.put(ch, name);

            ch = name.toUpperCase().charAt(name.length() - 1);
            last.add(ch);

        }


        // Find the head of the sequence
        // If first character of a name does not appear in last-character list then that name must be the head
        String head = null;
        for (String name : names) {
            char firstChar = name.charAt(0);
            if (!last.contains(firstChar)) {
                head = name;
                break;
            }
        }

        Map<String, String> backtracking = new HashMap<>(); // for a sequence name_i, name_j: map[name_j] -> name_i
        String tail = head;
        char lastChar = tail.toUpperCase().charAt(tail.length() - 1);
        while (first.containsKey(lastChar)) {
            // If we have a name whose first character is equal to the current chain last character

            String name = first.get(lastChar);

            // Point the new name to its previous (which is tail)
            backtracking.put(name, tail);

            // Set the new name as the new tail
            tail = name;

            // Remove new name from map
            first.remove(lastChar);


            // Get last character of the new tail
            lastChar = tail.toUpperCase().charAt(tail.length() - 1);
        }

        System.out.println(first);
        
        String[] ans = new String[names.length];
        int cursor = ans.length - 1;
        ans[cursor] = tail;
        cursor--;
        while (tail != null) {
            String prev = backtracking.get(tail);
            if (prev != null) {
                ans[cursor] = prev;
                cursor--;
            }
            tail = prev;
        }

        return ans;
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        List<String> nameList = new ArrayList<>();
        while (in.hasNext()) {
            String name = in.next();
            nameList.add(name);
        }

        // Convert list to array
        String[] names = new String[nameList.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = nameList.get(i);
        }

        String[] ans = chainNames(names);
        for (String name : ans) {
            System.out.print(name + " ");
        }

    }
}
