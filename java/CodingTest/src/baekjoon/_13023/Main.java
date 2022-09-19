package baekjoon._13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static boolean[] visited;
    private static ArrayList<Integer> graph[];
    private static boolean arrive;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (arrive) {
                break;
            }
        }
        if (arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int s, int k) {
        if (k == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[s] = true;

        for (int next : graph[s]) {
            if (!visited[next]) {
                dfs(next, k + 1);
            }
        }

        visited[s] = false;
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
    }

}
