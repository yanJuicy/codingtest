package baekjoon._1300;

import java.util.Scanner;

public class Main {

    private static int n, k;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long start = 1;
        long end = k;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt < k) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
    }
}
