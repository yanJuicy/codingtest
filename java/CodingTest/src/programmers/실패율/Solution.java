package programmers.실패율;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int[] solution(int N, int[] stages) {

        List<Boolean>[] scores = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            scores[i] = new ArrayList<>();
        }

        for (int stage : stages) {
            for (int i = 1; i < stage; i++) {
                scores[i].add(true);
            }
            if (stage <= N) {
                scores[stage].add(false);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int reach = scores[i].size();
            int notClear = 0;

            for (boolean isClear : scores[i]) {
                if (!isClear) {
                    notClear++;
                }
            }

            double failure = 0;
            if (reach != 0) {
                failure = (double) notClear / reach;
            }

            pq.offer(new Node(i, failure));
        }

        int[] answer = new int[pq.size()];
        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll().idx;
        }
        return answer;
    }

    private class Node implements Comparable<Node> {
        int idx;
        double failure;

        Node(int idx, double failure) {
            this.idx = idx;
            this.failure = failure;
        }

        @Override
        public int compareTo(Node o) {
            if (o.failure == failure) {
                return idx - o.idx;
            }
            return o.failure < failure ? -1 : 1;
        }
    }
}
