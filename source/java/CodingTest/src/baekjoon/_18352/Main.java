package baekjoon._18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, k, x;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visit;
    private static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        bfs(x);
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int i : result) {
                System.out.println(i);
            }
        }
    }

    private static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        visit[x] = true;

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                if (step == k) {
                    result.add(cur);
                }

                for (int next : graph[cur]) {
                    if (!visit[next]) {
                        visit[next] = true;
                        q.add(next);
                    }
                }
            }
            step++;
        }

    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        result = new ArrayList<>();
        visit = new boolean[n + 1];
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
