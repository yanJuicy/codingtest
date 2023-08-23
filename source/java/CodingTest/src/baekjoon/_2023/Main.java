package baekjoon._2023;

import java.util.Scanner;

public class Main {

    private static int n;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        System.out.println(sb.toString());
    }

    private static void dfs(int s, int k) {
        if (!isPrime(s)) {
            return;
        }

        if (k == n) {
            sb.append(s).append('\n');
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            dfs(s * 10 + i, k + 1);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }
}
