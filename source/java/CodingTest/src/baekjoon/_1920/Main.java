package baekjoon._1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int N, M;
    private static int a[], m[];

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(a);
        for (int i=0; i<M; i++) {
            if (Arrays.binarySearch(a, m[i]) >= 0)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) a[i] = sc.nextInt();
        M = sc.nextInt();
        m = new int[M];
        for (int i = 0; i < M; i++) m[i] = sc.nextInt();
        sc.close();
    }
}
