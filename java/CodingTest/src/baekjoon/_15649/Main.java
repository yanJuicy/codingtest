package baekjoon._15649;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] selected;
    static boolean[] isUsed;
    static StringBuilder sb;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[N + 1];
        isUsed = new boolean[N + 1];
        sb = new StringBuilder();
    }

    static void solve(int k) {
        if (k == M + 1) {
            for (int i=1; i<=M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int cand = 1; cand <= N; cand ++) {
                if (isUsed[cand] == true) continue;
                selected[k] = cand;
                isUsed[cand] = true;

                solve(k + 1);

                selected[k] = 0;
                isUsed[cand] = false;
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve(1);
        System.out.println(sb.toString());
    }
}
