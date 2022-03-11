package baekjoon._2110;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, C;
    static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(a);
        int l = 0;
        int r = 1000000000;
        int result = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (determine(mid)) {
                l = mid + 1;
                result = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean determine(int step) {
        int cnt = 1;
        int last = 0;
        for (int i = 1; i < N; i++) {
            if (a[i] - a[last] >= step) {
                cnt++;
                last = i;
            }
        }

        return cnt >= C;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = sc.nextInt();
        sc.close();
    }
}
