package baekjoon._1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    private static int V, E;
    private static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int[] p = new int[V];
        for (int i = 0; i < V; i++) {
            p[i] = i;
        }

        int completEdge = 0;
        int res = 0;
        while (completEdge < V - 1) {
            Node cur = pq.poll();
            int s = cur.s;
            int e = cur.e;

            if (find(s, p) != find(e, p)) {
                union(s, e, p);
                completEdge++;
                res += cur.v;
            }
        }

        System.out.println(res);
    }

    private static void union(int a, int b, int[] p) {
        a = find(a, p);
        b = find(b, p);

        p[b] = p[a];
    }

    private static int find(int s, int[] p) {
        if (s == p[s]) {
            return s;
        }
        return p[s] = find(p[s], p);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        V = Integer.parseInt(split[0]);
        E = Integer.parseInt(split[1]);

        pq = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            split = bufferedReader.readLine().split(" ");
            int s = Integer.parseInt(split[0]) - 1;
            int e = Integer.parseInt(split[1]) - 1;
            int v = Integer.parseInt(split[2]);
            pq.offer(new Node(s, e, v));
        }
    }

    private static class Node implements Comparable<Node> {
        int s, e, v;

        public Node(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return v - o.v;
        }
    }

}
