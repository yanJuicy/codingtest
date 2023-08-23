package baekjoon._11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int n;
    private static int[] a, s;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(a);

        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += s[i];
        }
        System.out.println(sum);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        a = new int[n + 1];
        s = new int[n + 1];
        String[] inputs = bufferedReader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(inputs[i - 1]);
        }
    }
}