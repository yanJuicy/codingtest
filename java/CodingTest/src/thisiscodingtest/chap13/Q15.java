package thisiscodingtest.chap13;

import java.util.*;

public class Q15 {

    static Scanner sc = new Scanner(System.in);
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) {
        int n, m, k, x;

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        distance = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        List<Integer> result = solve(n, k, x);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static List<Integer> solve(int n, int k, int x) {
        List<Integer> result = new ArrayList<>();

        bfs(x);
        boolean check = false;
        for (int i=1; i<=n; i++) {
            if (distance[i] == k) {
                result.add(i);
                check = true;
            }
        }

        if (!check) {
            result.add(-1);
        }

        return result;
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int n : graph.get(cur)) {
                if (!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                    distance[n] = distance[cur] + 1;
                }
            }
        }
    }
}
