package baekjoon._1929;

import java.util.Scanner;

public class Main {

    private static int m, n;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean[] notPrime = new boolean[n + 1];
        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (notPrime[i]) {
                continue;
            }

            for (int j = i + i; j <= n; j += i) {
                notPrime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (!notPrime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
    }

}
