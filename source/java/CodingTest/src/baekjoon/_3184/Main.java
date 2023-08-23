package baekjoon._3184;

import java.util.Scanner;

public class Main {

    static int r, c;
    static String[] graph;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int sheep, wolf;
    static int a, b;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < graph[i].length(); j++) {
                if (graph[i].charAt(j) != '#' && !visit[i][j]) {
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);

                    if (sheep > wolf)
                        wolf = 0;
                    else
                        sheep = 0;
                    a += sheep;
                    b += wolf;
                }
            }
        }

        System.out.println(a + " " + b);
    }

    private static void dfs(int i, int j) {
        visit[i][j] = true;

        if (graph[i].charAt(j) == 'v')
            wolf++;
        if (graph[i].charAt(j) == 'o')
            sheep++;

        for (int x = 0; x < 4; x++) {
            int di = i + dx[x];
            int dj = j + dy[x];

            if (di < 0 || di >= r || dj < 0 || dj >= c)
                continue;

            if (!visit[di][dj] && graph[di].charAt(dj) != '#')
                dfs(di, dj);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        graph = new String[r];
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++)
            graph[i] = sc.next();
        sc.close();
    }
}
