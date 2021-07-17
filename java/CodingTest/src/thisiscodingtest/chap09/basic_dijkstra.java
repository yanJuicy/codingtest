package thisiscodingtest.chap09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class basic_dijkstra {

    static final int INF = (int) 1e9;   // 무한을 의미
    static int n, m, start; // 노드의 수, 간선의 수, 시작 번호
    static List<ArrayList<Node>> graph = new ArrayList<>(); // 노드에 대한 정보를 담는 배열
    static boolean[] visited = new boolean[100001]; // 방문 체크
    static int[] d = new int[100001];   // 최단 거리 테이블

    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0;
        for (int i=1; i<=n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0;
        visited[start] = true;
        for (int j=0; j<graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        // 시작 노드를 제외한 전체 n-1개의 노드에 대해 반복
        for (int i=0; i<n-1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드를 확인
            for (int j=0; j<graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
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
            graph.get(a).add(new Node(b, c));
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

class Node {
    int index;
    int distance;

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}
