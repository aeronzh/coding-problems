package problems;

import java.util.*;

/**
 * Given a string S find the number of "unordered anagrammatic pairs" of substrings.
 */
public class SherlockAndAnagrams {

    public static long c(int n, int k) {
        // C(n,k) = n!/(k!*(n-k)!)

        long numerator = 1;
        for (int i = 0; i < k; i++) {
            numerator = (numerator * (n - i));
        }

        long denominator = 1;
        for (int i = 1; i <= k; i++) {
            denominator = (denominator * i);
        }

        return (numerator / denominator);
    }

    private static int solve(String str) {
        char[] ch = str.toCharArray();
        int n = str.length();

        Map<String, Integer> anagrams = new HashMap<String, Integer>();
        for (int i=0; i<n; i++) {
            String sub = ""+ch[i];
            char[] subArray = sub.toCharArray();
            Arrays.sort(subArray);
            String tmp = new String(subArray);

            if (anagrams.containsKey(tmp)) {
                int c = anagrams.get(tmp);
                c++;
                anagrams.put(tmp, c);
            } else {
                anagrams.put(tmp, 1);
            }
            for (int j=i+1; j<n; j++) {
                sub += ch[j];
                subArray = sub.toCharArray();
                Arrays.sort(subArray);
                tmp = new String(subArray);
                if (anagrams.containsKey(tmp)) {
                    int c = anagrams.get(tmp);
                    c++;
                    anagrams.put(tmp, c);
                } else {
                    anagrams.put(tmp, 1);
                }
            }
        }


        int total = 0;
        for (String subseq:anagrams.keySet()) {
            int count = anagrams.get(subseq);
            total += c(count,2);
        }


        return total;
    }

    public static void main(String[] args) {
        System.out.println(solve("zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw"));
    }
}
