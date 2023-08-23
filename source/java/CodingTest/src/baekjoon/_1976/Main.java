package baekjoon._1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[][] graph;
    private static int[] plan;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    union(i, j, p);
                }
            }
        }

        int parent = find(plan[0] - 1, p);
        for (int i : plan) {
            i--;
            if (find(i, p) != parent) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static void union(int a, int b, int[] p) {
        a = find(a, p);
        b = find(b, p);

        p[b] = a;
    }

    private static int find(int x, int[] p) {
        if (x == p[x])
            return x;
        return p[x] = find(p[x], p);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        plan = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

    }
}
