package pooshapman.sort;

import java.util.*;

public class SortTest03_pq {

    public static void main(String[] args) {
        int[] stick = {1, 8, 3, 5};

        System.out.println(solve(stick));
    }

    private static int solve(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.offer(n);
        }

        int result = 0;

        while (pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();
            result += a + b;
            pq.offer(a + b);
        }
        return result;
    }

}
