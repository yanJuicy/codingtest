package baekjoon._1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static long result;
    private static int[] a, temp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        mergeSort(0, a.length - 1);
        System.out.println(result);
    }

    private static void mergeSort(int s, int e) {
        if (s == e) {
            return;
        }

        int m = (s + e) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);

        for (int i = s; i <= e; i++) {
            temp[i] = a[i];
        }

        int k = s;
        int idx1 = s;
        int idx2 = m + 1;
        while (idx1 <= m && idx2 <= e) {
            if (temp[idx1] <= temp[idx2]) {
                a[k++] = temp[idx1++];
            } else {
                result += idx2 - k;
                a[k++] = temp[idx2++];
            }
        }

        while (idx1 <= m) {
            a[k++] = temp[idx1++];
        }
        while (idx2 <= e) {
            a[k++] = temp[idx2++];
        }
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        a = new int[n];
        temp = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }
}
