package baekjoon._1463;

import java.util.Scanner;

public class Main {

    private static int n;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int d[] = new int[n + 1];
        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 3 == 0) {
                d[i] = Math.min(d[i / 3] + 1, d[i]);
            }
            if (i % 2 == 0) {
                d[i] = Math.min(d[i / 2] + 1, d[i]);
            }
        }

        System.out.println(d[n]);
    }

    private static void input() {
        n = new Scanner(System.in).nextInt();
    }
}
