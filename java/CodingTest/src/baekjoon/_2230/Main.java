package baekjoon._2230;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(a);
        int right = 1;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int left = 0; left < n; left++) {

            while (right < n - 1 && Math.abs(a[right] - a[left]) < m) {
                right++;
            }

            sum = Math.abs(a[right] - a[left]);
            if (sum >= m)
                result = Math.min(result, sum);
        }

        System.out.println(result);
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
