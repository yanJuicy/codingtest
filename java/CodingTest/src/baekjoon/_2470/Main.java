package baekjoon._2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(arr, 1, N + 1);

        int maxValue = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;

        for (int i = 1; i <= N - 1; i++) {
            int cand = lowerBound(i + 1, -arr[i]);

            if (i + 1 <= cand - 1 && cand - 1 <= N && Math.abs(arr[cand - 1] + arr[i]) < maxValue) {
                maxValue = Math.abs(arr[cand - 1] + arr[i]);
                v1 = arr[i];
                v2 = arr[cand - 1];
            }

            if (i + 1 <= cand && cand <= N && Math.abs(arr[cand] + arr[i]) < maxValue) {
                maxValue = Math.abs(arr[cand] + arr[i]);
                v1 = arr[i];
                v2 = arr[cand];
            }
        }

        if (v1 > v2)
            System.out.println(v2 + " " + v1);
        else
            System.out.println(v1 + " " + v2);
    }

    private static int lowerBound(int l, int x) {
        int r = N;
        int res = N + 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= x) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
