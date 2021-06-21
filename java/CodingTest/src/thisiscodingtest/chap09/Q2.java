package thisiscodingtest.chap09;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    static final int INF = (int) 1e9;
    static int n, m, x, k;
    static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=1; i<=n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        System.out.println(distance >= INF ? -1 : distance);
    }
}
