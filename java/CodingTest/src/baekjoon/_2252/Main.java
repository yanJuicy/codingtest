package baekjoon._2252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] inputDegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i<=n; i++) {
            if (inputDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next : list.get(cur)) {
                inputDegree[next]--;
                if (inputDegree[next] == 0)
                    q.offer(next);
            }
        }

        System.out.println(sb.toString());
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        inputDegree = new int[n + 1];

        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            inputDegree[b]++;
            list.get(a).add(b);
        }

        sc.close();
    }
}
