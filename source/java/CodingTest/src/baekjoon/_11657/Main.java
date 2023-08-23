package baekjoon._11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int n, m;
    private static Edge edges[];

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        long d[] = new long[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge e : edges) {
                if (d[e.s] != Integer.MAX_VALUE && d[e.e] > d[e.s] + e.v) {
                    d[e.e] = d[e.s] + e.v;
                }
            }
        }

        boolean mCycle = false;
        for (Edge e : edges) {
            if (d[e.s] != Integer.MAX_VALUE && d[e.e] > d[e.s] + e.v) {
                mCycle = true;
            }
        }

        if (mCycle) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= n; i++) {
                if (d[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(d[i]);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bufferedReader.readLine().split(" ");
        n = Integer.valueOf(inputs[0]);
        m = Integer.valueOf(inputs[1]);

        edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            inputs = bufferedReader.readLine().split(" ");
            int a = Integer.valueOf(inputs[0]);
            int b = Integer.valueOf(inputs[1]);
            int c = Integer.valueOf(inputs[2]);
            edges[i] = new Edge(a, b, c);
        }
    }

    private static class Edge {
        int s, e, v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
}
