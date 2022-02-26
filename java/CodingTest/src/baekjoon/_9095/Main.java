package baekjoon._9095;

import java.util.Scanner;

public class Main {

    static int t, n;
    static Scanner sc = new Scanner(System.in);
    static int[] d = new int[11];

    public static void main(String[] args) {
        t = sc.nextInt();
        solve();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            System.out.println(d[n]);
        }
    }

    private static void solve() {
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i <= 10; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }
    }
}
