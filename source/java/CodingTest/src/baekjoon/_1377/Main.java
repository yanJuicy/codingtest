package baekjoon._1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int n;
    private static Node[] a;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(a);
        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            if (a[i].idx - i > maxValue) {
                maxValue = a[i].idx - i;
            }
        }

        System.out.println(maxValue + 1);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        a = new Node[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Node(i, Integer.parseInt(bufferedReader.readLine()));
        }
    }

    private static class Node implements Comparable<Node> {
        int value;
        int idx;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
