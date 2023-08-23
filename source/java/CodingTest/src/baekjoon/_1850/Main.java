package baekjoon._1850;

import java.util.Scanner;

public class Main {

    private static long a, b;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = (int) gcd(a, b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append('1');
        }

        System.out.println(sb.toString());
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
    }

}
