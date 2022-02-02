package baekjoon._7795;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static Scanner sc = new Scanner(System.in);
    static int[] A, B;

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
    }

    private static void solve() {
        Arrays.sort(B);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += find(A[i]);
        }
        System.out.println(cnt);
    }

    private static int find(int x) {
        int l = 0, r = M - 1;
        int result = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (B[mid] < x) {
                result = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N];
        B = new int[M];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        for (int i = 0; i < M; i++)
            B[i] = sc.nextInt();
    }
}
