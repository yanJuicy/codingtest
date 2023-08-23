package baekjoon._11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n, m;
    private static int[][] d;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    d[s][e] = Math.min(d[s][e], d[s][k] + d[k][e]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == 10000001) {
                    sb.append(0).append(' ');
                } else {
                    sb.append(d[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());

        d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            if (d[a][b] > c) {
                d[a][b] = c;
            }
        }

    }

}
