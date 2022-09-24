package programmers.두_큐_합_같게_만들기;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long l = 0;
        long r = 0;
        for (int n : queue1) {
            q1.offer(n);
            l += n;
        }
        for (int n : queue2) {
            q2.offer(n);
            r += n;
        }

        int cnt = 0;
        boolean success = false;
        for (int i = 0; i < queue1.length * 4; i++) {
            if (l == r) {
                success = true;
                break;
            } else if (l < r) {
                int tmp = q2.poll();
                r -= tmp;
                l += tmp;
                q1.add(tmp);
            } else {
                int tmp = q1.poll();
                l -= tmp;
                r += tmp;
                q2.add(tmp);
            }
            cnt++;
        }

        if (success) {
            return cnt;
        } else {
            return -1;
        }
    }

}
