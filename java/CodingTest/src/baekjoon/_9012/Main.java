package baekjoon._9012;

import java.util.Scanner;

public class Main {

    static int T;
    static StringBuilder sb = new StringBuilder();
    static String[] inputs;

    public static void main(String[] args) {
        input();
        for (int i=0; i<T; i++) {
            solve(inputs[i]);
        }
        System.out.println(sb.toString());
    }

    private static void solve(String str) {
        int l = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') l++;
            else l--;

            if (l < 0) {
                sb.append("NO\n");
                return;
            }
        }

        if (l == 0)
            sb.append("YES\n");
        else
            sb.append("NO\n");
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        inputs = new String[T];
        for (int i=0; i<T; i++) {
            inputs[i] = sc.next();
        }
    }
}
