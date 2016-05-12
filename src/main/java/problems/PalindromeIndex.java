package problems;

/**
 * Created by lucas on 27/02/16.
 */
public class PalindromeIndex {
    private static boolean isPalidrome(String str) {
        int n = str.length();
        char[] ch = str.toCharArray();
        for (int i=0; i<n/2; i++) {
            if (ch[i] != ch[n-1-i]) {
                return false;
            }
        }

        return true;
    }

    public static int solve(String str) {
        int n = str.length();
        char[] ch = str.toCharArray();
        int index = -1;

        for (int i=0; i<n/2; i++) {
            System.out.println(ch[i]+"("+i+") vs "+ch[n-1-i]+"("+(n-1-i)+")");
            if (ch[i] != ch[n-1-i]) {
                if (isPalidrome(str.substring(0,i)+str.substring(i+1,n))) {
                    index = i;
                    break;
                } else {
                    index = n-1-i;
                    break;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        String str = "hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh";
        System.out.println(solve(str));
    }
}
