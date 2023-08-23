package baekjoon._2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static String[] arr;
    static boolean[][] visited;
    static int groupCnt;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i].charAt(j) == '1' && !visited[i][j]) {
                    groupCnt = 0;
                    dfs(i, j);
                    list.add(groupCnt);
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (int cnt : list)
            sb.append(cnt).append("\n");

        System.out.println(sb.toString());
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        groupCnt++;

        for (int x = 0; x < 4; x++) {
            int ni = i + dx[x];
            int nj = j + dy[x];

            if (ni < 0 || ni >= n || nj < 0 || nj >= n)
                continue;
            if (!visited[ni][nj] && arr[ni].charAt(nj) == '1')
                dfs(ni, nj);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new String[n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.next();

        sc.close();
    }
}
