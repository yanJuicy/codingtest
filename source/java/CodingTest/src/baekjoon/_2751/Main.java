package baekjoon._2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[] a, tmp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        merge_sort(0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void merge_sort(int s, int e) {
        if (s == e) {
            return;
        }
        int m = (s + e) / 2;
        merge_sort(s, m);
        merge_sort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = a[i];
        }
        int idx = s;
        int idx1 = s;
        int idx2 = m + 1;

        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1] < tmp[idx2]) {
                a[idx++] = tmp[idx1++];
            } else {
                a[idx++] = tmp[idx2++];
            }
        }

        while (idx1 <= m) {
            a[idx++] = tmp[idx1++];
        }
        while (idx2 <= e) {
            a[idx++] = tmp[idx2++];
        }
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        a = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

}
