package baekjoon._1016;

import java.util.Scanner;

public class Main {

    private static long min, max;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean[] not = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long power = i * i;
            long s_idx = min / power;
            if (min % power != 0) {
                s_idx++;
            }

            for (long j = s_idx; j * power <= max; j++) {
                not[(int) (j * power - min)] = true;
            }
        }


        int cnt = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!not[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        min = sc.nextLong();
        max = sc.nextLong();
    }

}
