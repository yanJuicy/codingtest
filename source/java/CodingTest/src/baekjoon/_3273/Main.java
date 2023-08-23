package baekjoon._3273;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, x;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (Arrays.binarySearch(arr, i + 1, n, x - arr[i]) >= 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        x = scanner.nextInt();
        scanner.close();
    }
}
