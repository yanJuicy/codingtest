package baekjoon._1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static ArrayList<Integer>[] graph;
    private static int[] inDegree, buildTime;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[buildTime.length];
        System.arraycopy(buildTime, 0, result, 0, buildTime.length);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                result[next] = Math.max(result[next], buildTime[next] + result[cur]);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        inDegree = new int[n + 1];
        buildTime = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int time = Integer.parseInt(st.nextToken());
            buildTime[i] = time;
            while (st.hasMoreTokens()) {
                int preBuilt = Integer.parseInt(st.nextToken());
                if (preBuilt == -1) {
                    break;
                }
                graph[preBuilt].add(i);
                inDegree[i]++;
            }
        }
    }
}
