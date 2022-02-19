package devcourse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    boolean[] visited;

    public int[] solution(int n, int[] passenger, int[][] train) {
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] t : train) {
            list.get(t[0]).add(t[1]);
            list.get(t[1]).add(t[0]);
        }

        bfs(1, passenger);

        int maxTotalPassengers = 0;
        int endStation = 1;
        for (int i = 1; i < n; i++) {
            if (passenger[i] >= maxTotalPassengers) {
                maxTotalPassengers = passenger[i];
                endStation = i + 1;
            }
        }

        int[] answer = {endStation, maxTotalPassengers};
        return answer;
    }

    private void bfs(int x, int[] passenger) {
        Queue<Integer> q = new LinkedList<>();
        visited[x] = true;
        q.add(x);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                for (int next : list.get(cur)) {
                    if (!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                        passenger[next - 1] = passenger[next - 1] + passenger[cur - 1];
                    }
                }
            }
        }
    }

}