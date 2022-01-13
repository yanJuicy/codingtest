package baekjoon._1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        List[] adjList = new List[n+1];

        for (int i=0; i<n+1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adjList[s].add(e);
            adjList[e].add(s);
        }

        for (int i=1; i<=n; i++) {
            Collections.sort(adjList[i]);
        }

        boolean[] visited = new boolean[n+1];

        dfs(v, adjList, visited);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v, adjList, visited);
    }

    private static void dfs(int v, List<Integer>[] adjList, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int nextNode : adjList[v]) {
            if (!visited[nextNode]) {
                dfs(nextNode, adjList, visited);
            }
        }
    }

    private static void bfs(int v, List<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while (!q.isEmpty()) {
            v = q.poll();
            visited[v] = true;

            System.out.print(v + " ");
            for (int nextNode : adjList[v]) {
                if (!visited[nextNode]) {
                    q.offer(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}
