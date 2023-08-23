package baekjoon._14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[] t, p;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int[] d = new int[n + 2];

        for (int i = n; i > 0; i--) {
            if (i + t[i] > n + 1) {
                d[i] = d[i + 1];
            } else {
                d[i] = Math.max(d[i + 1], p[i] + d[i + t[i]]);
            }
        }

        System.out.println(d[1]);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        t = new int[n + 1];
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] reads = bufferedReader.readLine().split(" ");
            t[i] = Integer.parseInt(reads[0]);
            p[i] = Integer.parseInt(reads[1]);
        }
    }

}
