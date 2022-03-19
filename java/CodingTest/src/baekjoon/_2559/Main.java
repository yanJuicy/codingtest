package baekjoon._2559;

import java.util.Scanner;

public class Main {

    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int r = 0, sum = 0, res = 0;
        for (int l = 1; l <= n - k + 1; l++) {
            sum -= a[l - 1];

            while (r + 1 <= n && r + 1 != l + k) {
                r++;
                sum += a[r];
            }

            res = Math.max(sum, res);
        }
        System.out.println(res);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        sc.close();
    }
}
