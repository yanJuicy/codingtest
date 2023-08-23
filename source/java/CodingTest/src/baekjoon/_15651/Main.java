package baekjoon._15651;

import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] selected;
    static StringBuilder sb;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[N + 1];
        sb = new StringBuilder();
    }

    static void solve(int k) {
        if (k == M + 1) {
            for (int i=1; i<=M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                solve(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve(1);
        System.out.println(sb.toString());
    }
}
