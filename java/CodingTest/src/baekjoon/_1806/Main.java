package baekjoon._1806;

import java.util.Scanner;

public class Main {

    static int N, S;
    static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int R = 0, sum = 0, ans = N + 1;
        for (int L = 1; L <= N; L++) {
            sum -= a[L - 1];

            while (R + 1 <= N && sum < S) {
                R++;
                sum += a[R];
            }

            if (sum >= S) {
                ans = Math.min(ans, R - L + 1);
            }
        }

        if (ans == N + 1)
            ans = 0;
        System.out.println(ans);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        a = new int[N + 1];
        for (int i = 1; i <= N; i++)
            a[i] = sc.nextInt();
        sc.close();
    }
}
