package baekjoon._1654;

import java.util.Scanner;

public class Main {

    static int k, n;
    static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long l = 1;
        long r = Integer.MAX_VALUE;
        long res = 0;

        while (l <= r) {
            long h = (l + r) / 2;
            if (validate(h)) {
                l = h + 1;
                res = h;
            } else {
                r = h - 1;
            }
        }
        System.out.println(res);
    }

    private static boolean validate(long h) {
        long cnt = 0;
        for (int i = 0; i < a.length; i++) {
            cnt += a[i] / h;
        }
        return cnt >= n;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        a = new int[k];
        for (int i = 0; i < k; i++)
            a[i] = sc.nextInt();
        sc.close();
    }
}
