package baekjoon._2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    static int N;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(q.poll());
    }

    private static void solve() {
        while (q.size() != 1) {
            q.poll();
            q.offer(q.poll());
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i=1; i<=N; i++)
            q.offer(i);
    }
}
