package problems;


public class ValidParenthesesInString {
    private static boolean validate(String str) {
        boolean result = true;

        int openParentheses = 0;
        int openSquare = 0;
        int openCurly = 0;

        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    openParentheses++;
                    break;
                case ')':
                    openParentheses--;
                    break;
                case '{':
                    openCurly++;
                    break;
                case '}':
                    openCurly--;
                    break;
                case '[':
                    openSquare++;
                    break;
                case ']':
                    openSquare--;
                    break;
                default:
                    break;
            }

            if (openParentheses < 0 || openCurly < 0 || openSquare < 0) {
                result = false;
                break;
            }
        }

        if (openParentheses > 0 || openCurly > 0 || openSquare > 0) {
            result = false;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(validate("(kjds(hfkj)sdhf"));
        System.out.println(validate("a(bcd)d"));
        System.out.println(validate("(sfdsf)(fsfsf"));
        System.out.println(validate("{[]}()"));
        System.out.println(validate("{[}]"));
    }
}
