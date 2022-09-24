package baekjoon._1176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int[] d = new int[n + 1];
        bfs(1, d, new boolean[n + 1]);
        int maxIdx = 1;
        for (int i = 2; i <= n; i++) {
            if (d[i] > d[maxIdx]) {
                maxIdx = i;
            }
        }

        d = new int[n + 1];
        bfs(maxIdx, d, new boolean[n + 1]);
        maxIdx = 1;
        for (int i = 2; i <= n; i++) {
            if (d[i] > d[maxIdx]) {
                maxIdx = i;
            }
        }

        System.out.println(d[maxIdx]);
    }

    private static void bfs(int x, int[] d, boolean[] visit) {
        visit[x] = true;
        d[x] = 0;

        Queue<Edge> q = new ArrayDeque<>();
        q.offer(new Edge(x, 0));

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            for (Edge next : graph[cur.s]) {
                if (!visit[next.s]) {
                    visit[next.s] = true;
                    q.offer(next);
                    d[next.s] = d[cur.s] + next.v;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());
                graph[s].add(new Edge(e, v));
            }
        }
    }

    private static class Edge {
        int s, v;

        public Edge(int s, int v) {
            this.s = s;
            this.v = v;
        }
    }
}
