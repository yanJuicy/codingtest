package baekjoon;

import java.io.*;
import java.util.*;

public class p_11779 {

    static int n, m;
    static List<List<Node>> graph;
    static int start, end;
    static int[] dist;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        input();
        dijkstra(start);
        output();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(dist[end] + "\n");
        Stack<Integer> st = new Stack<>();
        for (int i=end; i!=start; i=parent[i]) {
            st.push(i);
        }
        st.push(start);
        bw.write(st.size()+"\n");
        while (!st.isEmpty()) {
            bw.write(st.pop() + " ");
        }
        bw.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int distance = cur.weight;
            int now = cur.end;

            if (distance > dist[now])
                continue;

            for (Node nextNode : graph.get(now)) {
                int cost = nextNode.weight + distance;
                int next = nextNode.end;
                if (dist[next] > cost) {
                    dist[next] = cost;
                    pq.add(new Node(next, cost));
                    parent[next] = now;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        dist = new int[n + 1];
        int INF = (int) 1e9;
        Arrays.fill(dist, INF);

        graph = new ArrayList<>();

        for (int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        for (int i=0; i<m; i++) {
            int a, b, c;
            String[] strs = br.readLine().split(" ");
            a = Integer.parseInt(strs[0]);
            b = Integer.parseInt(strs[1]);
            c = Integer.parseInt(strs[2]);

            graph.get(a).add(new Node(b, c));
        }
        String[] strs = br.readLine().split(" ");
        start = Integer.parseInt(strs[0]);
        end = Integer.parseInt(strs[1]);
        br.close();
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
