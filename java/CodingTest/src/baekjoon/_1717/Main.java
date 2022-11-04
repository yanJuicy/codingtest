package baekjoon._1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int array[];
    private static BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (c == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        array[b] = a;
    }

    private static int find(int x) {
        if (array[x] != x) {
            return find(array[x]);
        }
        return x;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }
    }

}
