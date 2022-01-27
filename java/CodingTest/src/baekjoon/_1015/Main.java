package baekjoon._1015;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] A, B, P;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(sb.toString());
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[j] == B[i] && P[j] == -1) {
                    P[j] = i;
                    break;
                }
            }
        }

        for (int i : P) {
            sb.append(i + " ");
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        B = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = A[i];
        }

        Arrays.fill(P, -1);
        Arrays.sort(B);
    }
}
