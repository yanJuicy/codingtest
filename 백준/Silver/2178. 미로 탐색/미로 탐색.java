import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int n, m;
    private static int[][] graph;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int sr, int sc) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sr, sc));
        graph[sr][sc] = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            cnt++;
            while (len-- > 0) {
                Node cur = q.poll();
                int r = cur.r;
                int c = cur.c;

                if (r == n - 1 && c == m - 1) {
                    len = 0;
                    q.clear();
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];

                    if (nr < 0 || nr == n || nc < 0 || nc == m) {
                        continue;
                    }

                    if (graph[nr][nc] == 1) {
                        q.offer(new Node(nr, nc));
                        graph[nr][nc] = 0;
                    }
                }
            }
        }
        return cnt;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                graph[i][j] = (int) (s.charAt(j) - '0');
            }
        }
    }

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
