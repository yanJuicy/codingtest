package thisiscodingtest.chap09;

import java.util.*;

class QNode implements Comparable<QNode>{
    int index;
    int distance;

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public QNode(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(QNode o) {
        return distance < o.distance ? -1 : 1;
    }
}

public class Q3 {
    static int INF = (int) 1e9;
    static int n, m, c;
    static List<List<QNode>> graph = new ArrayList<>();
    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        d = new int[n + 1];
        Arrays.fill(d, INF);
        for (int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new QNode(y, z));
        }

        dijkstra(c);

        int count = 0;
        int maxDistance = 0;
        for (int i=1; i<=n; i++) {
            if (d[i] != INF) {
                count++;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        System.out.println(count - 1 + " " + maxDistance);
    }

    private static void dijkstra(int start) {
        PriorityQueue<QNode> pq = new PriorityQueue<>();
        pq.offer(new QNode(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            QNode cur = pq.poll();
            int dist = cur.getDistance();
            int now = cur.getIndex();

            if (d[now] < dist) {
                continue;
            }

            for (int i=0; i<graph.get(now).size(); i++) {
                int cost = dist + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new QNode(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }

    }


}
