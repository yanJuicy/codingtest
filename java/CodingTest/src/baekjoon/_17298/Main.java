package baekjoon._17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static int n;
    private static int[] a, ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && a[st.peek()] < a[i]) {
                int idx = st.pop();
                ans[idx] = a[i];
            }
            st.push(i);
        }

        while (!st.empty()) {
            int idx = st.pop();
            ans[idx] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i).append(' ');
        }
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        a = new int[n];
        ans = new int[n];
        String[] inputs = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(inputs[i]);
        }
    }

}
