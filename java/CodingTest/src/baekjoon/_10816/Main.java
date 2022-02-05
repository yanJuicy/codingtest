package baekjoon._10816;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] a, b;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(a);
        for (int i = 0; i < M; i++) {
            int cnt = upperBound(a, 0, N - 1, b[i]) - lowerBound(a, 0, N - 1, b[i]);
            if (cnt == -1) cnt = 0;
            sb.append(cnt).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int lowerBound(int[] arr, int l, int r, int x) {
        int idx = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > x) {
                r = mid - 1;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                idx = mid;
                r = mid - 1;
            }
        }
        return idx;
    }

    private static int upperBound(int[] arr, int l, int r, int x) {
        int idx = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > x) {
                r = mid - 1;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                idx = mid;
                l = mid + 1;
            }
        }
        if (idx != -1) idx++;
        return idx;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = sc.nextInt();
        M = sc.nextInt();
        b = new int[M];
        for (int i = 0; i < M; i++)
            b[i] = sc.nextInt();
        sc.close();
    }
}
