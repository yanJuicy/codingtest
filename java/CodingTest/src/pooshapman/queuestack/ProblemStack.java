package pooshapman.queuestack;

import java.util.Stack;

public class ProblemStack {
    public static void main(String[] args) {
        String s = "12[a]2[bc]2[d]";
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        StringBuilder result = new StringBuilder();
        Stack<StringBuilder> stringStack = new Stack<>();

        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {

                stringStack.push(result);
                result = new StringBuilder();

            } else if (c == ']') {
                StringBuilder str = stringStack.pop();

                for (int i=0; i<k; i++) {
                    str.append(result);
                }
                result = str;
                k = 0;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
