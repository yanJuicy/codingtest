package baekjoon._11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[][] d;

    public static void main(String[] args) throws NumberFormatException, IOException {
        input();
        solve();
    }

    private static void solve() {
        for (int k = 0; k < n; k++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    if (d[s][k] == 1 && d[k][e] == 1) {
                        d[s][e] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(d[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        d = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] inputs = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                d[i][j] = Integer.parseInt(inputs[j]);
            }
        }
    }

}
