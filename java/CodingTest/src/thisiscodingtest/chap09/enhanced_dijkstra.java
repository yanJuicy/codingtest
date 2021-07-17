package thisiscodingtest.chap09;

import java.util.*;

public class enhanced_dijkstra {

    static final int INF = (int) 1e9;   // 무한을 의미
    static int n, m, start; // 노드의 수, 간선의 수, 시작 번호
    static List<ArrayList<CNode>> graph = new ArrayList<>(); // 노드에 대한 정보를 담는 배열
    static int[] d = new int[100001];   // 최단 거리 테이블

    public static void dijkstra(int start) {
        PriorityQueue<CNode> pq = new PriorityQueue<>();
        d[start] = 0;
        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            CNode node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new CNode(graph.get(now).get(i).getIndex(), cost));
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new CNode(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i=1; i<=n; i++) {
            if (d[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }

    }

}

class CNode implements Comparable<Node> {
    int index;
    int distance;

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public CNode(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

