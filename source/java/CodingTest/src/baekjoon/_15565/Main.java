package baekjoon._15565;

import java.util.Scanner;

public class Main {

    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int r = 0, size = -1, cnt = 0;
        for (int l = 1; l <= n; l++) {
            while (r < n && cnt < k) {
                r++;
                if (a[r] == 1) cnt++;
            }

            if (cnt == k) {
                if (size == -1) size = r - l + 1;
                size = Math.min(size, r - l + 1);
            }

            if (a[l] == 1) cnt--;
        }
        System.out.println(size);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
    }
}
