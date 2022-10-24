package baekjoon._1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visit;
    private static int[] trust;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            bfs(i);
        }

        int maxValue = 0;
        for (int i = 1; i < trust.length; i++) {
            if (maxValue < trust[i]) {
                maxValue = trust[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < trust.length; i++) {
            if (trust[i] == maxValue) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visit[next]) {
                    q.add(next);
                    visit[next] = true;
                    trust[next]++;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trust = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
    }

}
