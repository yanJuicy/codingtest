package baekjoon._2343;

import java.util.Scanner;

public class Main {

    static int n, m;
    static int a[];

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int l = 1, r = 1000000000;
        int ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (determine(mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean determine(int len) {
        int sum = 0;
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            if (sum + a[i] > len) {
                sum = a[i];
                cnt++;
            } else {
                sum += a[i];
            }
        }

        return cnt <= m;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        sc.close();
    }
}
