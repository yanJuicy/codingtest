package baekjoon._20291;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(arr);
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i].equals(arr[i - 1])) {
                cnt++;
            } else {
                sb.append(arr[i - 1] + " " + cnt + "\n");
                cnt = 1;
            }

            if (i == N - 1)
                sb.append(arr[i] + " " + cnt + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            arr[i] = str.substring(str.indexOf('.') + 1);
        }

        sc.close();
    }
}
