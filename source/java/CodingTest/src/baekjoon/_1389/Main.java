package baekjoon._1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int N, M;
    private static int[][] d;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        for (int k = 0; k < N; k++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    if (d[s][e] > d[s][k] + d[k][e]) {
                        d[s][e] = d[s][k] + d[k][e];
                    }
                }
            }
        }

        int minD = Arrays.stream(d[0]).sum();
        int minIdx = 0;

        for (int i = 1; i < N; i++) {
            if (minD > Arrays.stream(d[i]).sum()) {
                minD = Arrays.stream(d[i]).sum();
                minIdx = i;
            }
        }

        System.out.println(minIdx + 1);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        d = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            split = bufferedReader.readLine().split(" ");
            int s = Integer.parseInt(split[0]) - 1;
            int e = Integer.parseInt(split[1]) - 1;
            d[s][e] = d[e][s] = 1;
        }
    }

}
