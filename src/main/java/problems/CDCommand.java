package problems;

import datastructures.MyStack;

/**
 * Implement the 'cd' command i.e. given a function cd('a/b','c/../d/e/../f'), where 1st param is current
 * directory and 2nd param is the sequence of operations, find the final directory that the user will be
 * in when the cd command is executed.
 */
public class CDCommand {

    private static final String BACK = "..";
    private static final String SLASH = "/";

    private static String cd(String current, String commands) {
        MyStack<String> stack = new MyStack<String>();
        String[] split = current.split(SLASH);
        for (String cmd:split) {
            stack.push(cmd);
        }


        split = commands.split(SLASH);
        for (String cmd:split) {
            if (BACK.equals(cmd)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(cmd);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String cmd = stack.pop();
            sb.insert(0,cmd);
            sb.insert(0,SLASH);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(cd("a/b","c/../d/e/../f"));
    }
}
