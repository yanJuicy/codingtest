package baekjoon._1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int n, m, from, to;
    private static Edge[] edges;
    private static int[] cityMoney;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        long d[] = new long[n];
        Arrays.fill(d, Long.MIN_VALUE);
        d[from] = cityMoney[from];

        for (int i = 0; i <= n + 100; i++) {
            for (int j = 0; j < m; j++) {
                int s = edges[j].s;
                int e = edges[j].e;
                int v = edges[j].v;

                if (d[s] == Long.MIN_VALUE) {
                    continue;
                } else if (d[s] == Long.MAX_VALUE) {
                    d[e] = Long.MAX_VALUE;
                } else if (d[e] < d[s] + cityMoney[e] - v) {
                    d[e] = d[s] + cityMoney[e] - v;
                    if (i >= n - 1) {
                        d[e] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if (d[to] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if (d[to] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(d[to]);
        }

    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        from = Integer.parseInt(inputs[1]);
        to = Integer.parseInt(inputs[2]);
        m = Integer.parseInt(inputs[3]);

        cityMoney = new int[n];
        edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            inputs = bufferedReader.readLine().split(" ");
            int s = Integer.parseInt(inputs[0]);
            int e = Integer.parseInt(inputs[1]);
            int v = Integer.parseInt(inputs[2]);
            edges[i] = new Edge(s, e, v);
        }

        inputs = bufferedReader.readLine().split(" ");
        for (int i = 0; i < inputs.length; i++) {
            cityMoney[i] = Integer.parseInt(inputs[i]);
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
