package baekjoon._9663;

import java.util.Scanner;

public class Main {

    static int N, ans;
    static int col[];   // col[i]: i번 행의 퀸은 col[i]번 열에 있다.

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(ans);
    }

    private static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {

                boolean possible = true;

                for (int i = 1; i <= row - 1; i++) {
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    private static boolean validity_check() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (attackable(i, col[i], j, col[j]))
                    return false;
            }
        }
        return true;
    }

    private static boolean attackable(int i, int j, int x, int y) {
        if (j == y) return true;
        else if (i - j == x - y) return true;
        else if (i + j == x + y) return true;
        return false;
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N + 1];
    }

}
