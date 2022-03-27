package baekjoon._11728;

import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] a, b;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int indexA = 0;
        int indexB = 0;

        while (indexA < n && indexB < m) {
            if (a[indexA] < b[indexB]) {
                sb.append(a[indexA++]).append(" ");
            } else {
                sb.append(b[indexB++]).append(" ");
            }
        }

        while (indexA < n)
            sb.append(a[indexA++]).append(" ");
        while (indexB < m)
            sb.append(b[indexB++]).append(" ");

        System.out.println(sb.toString());
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
    }
}
