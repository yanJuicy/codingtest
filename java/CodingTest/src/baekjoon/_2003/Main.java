package baekjoon._2003;

import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int r = 0, cnt = 0, sum = 0;
        for (int l = 1; l <= n; l++) {
            sum -= a[l - 1];

            while (r + 1 <= n && sum < m) {
                r++;
                sum += a[r];
            }

            if (sum == m)
                cnt++;
        }

        System.out.println(cnt);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
    }
}
