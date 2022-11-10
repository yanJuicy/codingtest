package baekjoon._2800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {

    private static String s;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Set<String> set = new HashSet<>();
        int[] opToNum = new int[s.length()];

        Stack<int[]> st = new Stack<>();

        int idx = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(new int[] { i, idx++ });
            }
            if (s.charAt(i) == ')') {
                int[] top = st.pop();
                opToNum[i] = top[1];
                opToNum[top[0]] = top[1];
            }
        }

        rec_solve(opToNum, 1, idx, set);

        List<String> result = new ArrayList<>();

        for (String str : set) {
            result.add(str);
        }

        Collections.sort(result);

        for (String str : result) {
            System.out.println(str);
        }
    }

    private static void rec_solve(int[] arr, int cur, int last, Set<String> set) {
        if (cur == last) {
            return;
        }

        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        for (int step = cur; step < last; step++) {
            rec_solve(temp, step + 1, last, set);

            for (int i = 0; i < arr.length; i++) {
                if (temp[i] == step) {
                    temp[i] = -1;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (temp[i] != -1) {
                    sb.append(s.charAt(i));
                }
            }

            set.add(sb.toString());
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
    }

}