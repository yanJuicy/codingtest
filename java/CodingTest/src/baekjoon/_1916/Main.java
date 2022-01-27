package baekjoon._1916;

import java.util.*;

public class Main {

    static int n, m;
    static int start, end;
    static List<List<Node>> graph;
    static int[] dist;

    public static void main(String[] args) {
        input();
        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int distance = cur.weight;
            int now = cur.end;

            if (dist[now] < distance)
                continue;

            for (Node next : graph.get(now)) {
                int nextNode = next.end;
                int cost = distance + next.weight;

                if (cost < dist[nextNode]) {
                    dist[nextNode] = cost;
                    pq.offer(new Node(nextNode, cost));
                }
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        dist = new int[n + 1];

        int INF = (int) 1e9;
        Arrays.fill(dist, INF);

        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        start = sc.nextInt();
        end = sc.nextInt();

        sc.close();
    }
}

class Node implements Comparable<Node> {
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