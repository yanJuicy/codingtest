package baekjoon._11286;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] inputs;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        if (Math.abs(o1) == Math.abs(o2)) {
            return o1 - o2;
        }
        return Math.abs(o1) - Math.abs(o2);
    });
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(sb.toString());
    }

    private static void solve() {
        for (int i=0; i<N; i++) {
            if (inputs[i] == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll() + "\n");
                }
            } else {
                pq.offer(inputs[i]);
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        inputs = new int[N];
        for (int i=0; i<N; i++)
            inputs[i] = sc.nextInt();
    }
}
