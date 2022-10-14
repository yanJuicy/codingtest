package baekjoon._1934;

import java.util.Scanner;

public class Main {

    private static int t;
    private static int a, b;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        for (int i = 0; i < t; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            solve();
        }
    }

    private static void solve() {
        System.out.println(a * b / gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static void input() {
        t = sc.nextInt();
    }
}
