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
        Deque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && a[i] < deque.peekLast().value) {
                deque.removeLast();
            }
            deque.add(new Node(i, a[i]));
            if (deque.peekFirst().idx <= i - l) {
                deque.removeFirst();
            }
            sb.append(deque.peekFirst().value).append(' ');
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

    private static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

}
