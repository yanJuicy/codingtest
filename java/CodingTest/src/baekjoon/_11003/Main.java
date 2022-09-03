package baekjoon._11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static int n, l;
    private static int[] a;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && i % l == 0) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && a[i] < deque.peekLast()) {
                deque.removeLast();
            }
            deque.add(a[i]);

            sb.append(deque.peekFirst()).append(' ');
        }

        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        l = Integer.parseInt(inputs[1]);

        a = new int[n];

        inputs = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(inputs[i]);
        }
    }

}
