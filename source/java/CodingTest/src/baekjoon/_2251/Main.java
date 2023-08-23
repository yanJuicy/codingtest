package baekjoon._2251;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int[] now;
    private static boolean visit[][];
    private static boolean answer[];
    private static int[] sender = {0, 0, 1, 1, 2, 2};
    private static int[] receiver = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        bfs();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs() {
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0, 0));
        visit[0][0] = true;
        answer[now[2]] = true;

        while (!q.isEmpty()) {
            AB cur = q.poll();
            int A = cur.a;
            int B = cur.b;
            int C = now[2] - A - B;

            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;
                if (next[receiver[k]] > now[receiver[k]]) {
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]];
                    next[receiver[k]] = now[receiver[k]];
                }
                if (!visit[next[0]][next[1]]) {
                    q.add(new AB(next[0], next[1]));
                    visit[next[0]][next[1]] = true;
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();

        visit = new boolean[201][201];
        answer = new boolean[201];
    }

    private static class AB {
        int a, b;

        public AB(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
