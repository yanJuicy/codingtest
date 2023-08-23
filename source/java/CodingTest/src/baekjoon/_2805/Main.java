package baekjoon._2805;

import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long l = 1, r = 2000000000;
        long res = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (isOk(mid)) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(res);
    }

    private static boolean isOk(long height) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] > height) {
                cnt += a[i] - height;
            }
        }
        return cnt >= M;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = sc.nextInt();
        sc.close();
    }
}
