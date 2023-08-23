package baekjoon._1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int v, e;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visit;
    private static boolean isEven;
    private static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < k; i++) {
            input(bufferedReader);
            solve();
        }
    }

    private static void solve() {
        for (int i = 1; i <= v; i++) {
            if (!visit[i] && isEven) {
                dfs(i);
            }
            if (isEven == false) {
                break;
            }
        }

        if (isEven) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void dfs(int x) {
        visit[x] = true;

        for (int next : graph[x]) {
            if (!visit[next]) {
                check[next] = (check[x] + 1) % 2;
                dfs(next);
            } else if (check[next] == check[x]) {
                isEven = false;
            }
        }
    }

    private static void input(BufferedReader bufferedReader) throws IOException {
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        isEven = true;
        check = new int[v + 1];
        visit = new boolean[v + 1];
        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

    }

}
