package baekjoon._11725;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static List<List<Integer>> list;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(1, 1);
        for (int i = 2; i <= n; i++)
            System.out.println(parents[i]);
    }

    private static void dfs(int x, int parent) {
        visited[x] = true;
        parents[x] = parent;

        for (int next : list.get(x)) {
            if (!visited[next])
                dfs(next, x);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        parents = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            list.get(b).add(a);
        }

        sc.close();
    }
}
