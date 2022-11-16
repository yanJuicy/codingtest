package baekjoon._1854;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, k;
    private static ArrayList<Node> graph[];

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        PriorityQueue<Integer>[] dQueue = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            dQueue[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dQueue[1].add(0);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : graph[cur.dest]) {
                if (dQueue[next.dest].size() < k) {
                    dQueue[next.dest].add(cur.cost + next.cost);
                    pq.add(new Node(next.dest, cur.cost + next.cost));
                } else if (dQueue[next.dest].peek() > cur.cost + next.cost) {
                    dQueue[next.dest].poll();
                    dQueue[next.dest].add(cur.cost + next.cost);
                    pq.add(new Node(next.dest, cur.cost + next.cost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dQueue[i].size() == k) {
                sb.append(dQueue[i].peek()).append('\n');
            } else {
                sb.append(-1).append('\n');
            }
        }

        System.out.println(sb.toString());
    }


    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
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
