package baekjoon._1744;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static int n;
    private static PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> minus = new PriorityQueue<>();
    private static int one;
    private static int zero;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int sum = 0;

        while (plus.size() > 1) {
            sum += plus.poll() * plus.poll();
        }
        if (!plus.isEmpty()) {
            sum += plus.poll();
        }
        sum += one;

        while (minus.size() > 1) {
            sum += minus.poll() * minus.poll();
        }
        if (!minus.isEmpty()) {
            if (zero == 0) {
                sum += minus.poll();
            }
        }

        System.out.println(sum);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (k > 1) {
                plus.offer(k);
            } else if (k == 1) {
                one++;
            } else if (k == 0) {
                zero++;
            } else {
                minus.offer(k);
            }
        }
    }

}
