package baekjoon._1033;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int n;
    private static long lcm;
    private static ArrayList<Node>[] graph;
    private static boolean[] visit;
    private static long[] d;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        d[0] = lcm;
        dfs(0);
        long mgcd = lcm;
        for (int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, d[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(d[i] / mgcd).append(' ');
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int x) {
        visit[x] = true;

        for (Node i : graph[x]) {
            int next = i.b;
            if (!visit[next]) {
                d[next] = d[x] * i.q / i.p;
                dfs(next);
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new ArrayList[n];
        visit = new boolean[n];
        d = new long[n];
        lcm = 1;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
    }


    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static class Node {
        int b, p, q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }

}
