package baekjoon._1068;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n, x, root;
    static int[] leaf;
    static ArrayList<ArrayList<Integer>> child;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (ArrayList<Integer> a : child) {
            if (a.contains(x))
                a.remove((Integer) x);
        }
        if (root != x)
            dfs(root);
        System.out.println(leaf[root]);
    }

    private static void dfs(int v) {
        if (child.get(v).isEmpty())
            leaf[v] = 1;
        for (int next : child.get(v)) {
            dfs(next);
            leaf[v] += leaf[next];
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        leaf = new int[n];
        child = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            child.add(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v == -1) {
                root = i;
                continue;
            }
            child.get(v).add(i);
        }
        x = sc.nextInt();
        sc.close();
    }
}
