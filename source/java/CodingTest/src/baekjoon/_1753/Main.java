package baekjoon._1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int v, e, s;
    private static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        boolean[] visit = new boolean[v + 1];
        int[] d = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur.dest]) {
                continue;
            }

            visit[cur.dest] = true;
            for (Node next : graph[cur.dest]) {
                if (d[next.dest] > d[cur.dest] + next.cost) {
                    d[next.dest] = d[cur.dest] + next.cost;
                    pq.add(new Node(next.dest, d[next.dest]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            System.out.println(d[i] == Integer.MAX_VALUE ? "INF" : d[i]);
        }

    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        s = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }
    }

    private static class Node implements Comparable<Node> {
        int dest;
        int cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

}
