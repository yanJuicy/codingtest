package baekjoon._11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static List<ArrayList<Integer>> a;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int s) {
        visited[s] = true;

        for (int next : a.get(s)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        a = new ArrayList<>(n + 1);
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            a.get(u).add(v);
            a.get(v).add(u);
        }
    }

}
