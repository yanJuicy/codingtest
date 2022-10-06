package baekjoon._1456;

import java.util.Scanner;

public class Main {

    private static long a, b;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean[] notPrime = new boolean[10000001];
        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i * i < notPrime.length; i++) {
            if (notPrime[i]) {
                continue;
            }

            for (int j = i + i; j < notPrime.length; j += i) {
                notPrime[j] = true;
            }
        }

        int cnt = 0;
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                long tmp = i;

                while ((long) i <= b / tmp) {
                    if ((long) i >= a / tmp) {
                        cnt++;
                    }
                    tmp *= i;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
    }
}
