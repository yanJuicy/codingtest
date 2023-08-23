package baekjoon._17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static ArrayList<int[]> pointList;
    private static ArrayList<ArrayList<int[]>> mapPointList;
    private static PriorityQueue<Node> edges;
    private static int result = 0;
    private static int edgeCount = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int mapNum = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j, mapNum++);
                    mapPointList.add(pointList);
                }
            }
        }

        for (ArrayList<int[]> islandPoints : mapPointList) {
            for (int[] point : islandPoints) {
                int curNum = map[point[0]][point[1]];
                for (int k = 0; k < 4; k++) {
                    int nx = point[0] + dx[k];
                    int ny = point[1] + dy[k];

                    int length = 0;
                    while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == curNum) {
                            break;
                        } else if (map[nx][ny] > 0) {
                            if (length >= 2) {
                                edges.add(new Node(curNum, map[nx][ny], length));
                            }
                            break;
                        }

                        nx += dx[k];
                        ny += dy[k];
                        length++;
                    }
                }
            }
        }

        kruskal(mapNum);
        if (edgeCount == mapNum - 2) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static void kruskal(int mapNum) {
        int[] p = new int[mapNum];
        for (int i = 1; i < mapNum; i++) {
            p[i] = i;
        }

        while (!edges.isEmpty()) {
            Node cur = edges.poll();

            int s = cur.s;
            int e = cur.e;

            if (find(s, p) != find(e, p)) {
                union(s, e, p);
                result += cur.v;
                edgeCount++;
            }
        }
    }

    private static int find(int s, int[] p) {
        if (s == p[s]) {
            return s;
        }
        return p[s] = find(p[s], p);
    }

    private static void union(int s, int e, int[] p) {
        s = find(s, p);
        e = find(e, p);

        p[e] = s;
    }

    private static void bfs(int i, int j, int num) {
        pointList = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();

        visit[i][j] = true;
        q.offer(new int[] {i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            map[cur[0]][cur[1]] = num;
            pointList.add(cur);

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            split = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        mapPointList = new ArrayList<>();
        edges = new PriorityQueue<>();
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
