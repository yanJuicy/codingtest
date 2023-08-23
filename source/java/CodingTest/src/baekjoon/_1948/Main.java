package baekjoon._1948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, s, e;
    private static ArrayList<Node>[] roads, reverse;
    private static int[] inDegree;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int[] result = new int[n + 1];
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node next : roads[cur]) {
                inDegree[next.dest]--;
                result[next.dest] = Math.max(result[next.dest], result[cur] + next.cost);

                if (inDegree[next.dest] == 0) {
                    q.offer(next.dest);
                }
            }
        }

        int resultCount = 0;
        boolean visit[] = new boolean[n + 1];
        q = new LinkedList<>();
        q.offer(e);
        visit[e] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node next : reverse[now]) {
                if (result[next.dest] + next.cost == result[now]) {
                    resultCount++;
                    if (visit[next.dest] == false) {
                        visit[next.dest] = true;
                        q.offer(next.dest);
                    }
                }
            }
        }

        System.out.println(result[e]);
        System.out.println(resultCount);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());

        inDegree = new int[n + 1];

        roads = new ArrayList[n + 1];
        reverse = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            roads[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            roads[a].add(new Node(b, c));
            reverse[b].add(new Node(a, c));
            inDegree[b]++;
        }

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
    }

    private static class Node {
        int dest;
        int cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

}
