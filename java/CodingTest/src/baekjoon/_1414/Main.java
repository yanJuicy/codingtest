package baekjoon._1414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    private static int n;
    private static PriorityQueue<Node> pq;
    private static int sum;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int useEdges = 0;
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int s = cur.s;
            int e = cur.e;

            if (find(s, p) != find(e, p)) {
                union(s, e, p);
                useEdges++;
                sum -= cur.v;
            }

            if (useEdges == n - 1) {
                break;
            }
        }

        if (useEdges == n - 1) {
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }

    }

    private static int find(int a, int[] p) {
        if (a == p[a]) {
            return a;
        }
        return p[a] = find(p[a], p);
    }

    private static void union(int a, int b, int[] p) {
        a = find(a, p);
        b = find(b, p);

        p[b] = a;
    }

    private static void input() throws IOException {
        pq = new PriorityQueue<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String read = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                char alphabet = read.charAt(j);
                if (alphabet >= 'a' && alphabet <= 'z') {
                    int temp = alphabet - 'a' + 1;
                    pq.add(new Node(i, j, temp));
                    sum += temp;
                } else if (alphabet >= 'A' && alphabet <= 'Z') {
                    int temp = alphabet - 'A' + 27;
                    pq.add(new Node(i, j, temp));
                    sum += temp;
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int s, e, v;

        public Node(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return v - o.v;
        }
    }

}
