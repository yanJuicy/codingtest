package baekjoon._11689;

import java.util.Scanner;

public class Main {

    private static long n;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long result = n;
        for (long p = 2; p * p <= n; p++) {
            if (n % p != 0) {
                continue;
            }
            result = result - result / p;
            while (n % p == 0) {
                n /= p;
            }
        }

        if (n > 1) {
            result = result - result / n;
        }
        System.out.println(result);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
    }

}
