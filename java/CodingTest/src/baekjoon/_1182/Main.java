package baekjoon._1182;

import java.util.Scanner;

public class Main {

    static int N, S, ans;
    static int nums[];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        if (S == 0)
            ans--;
        System.out.println(ans);
    }

    private static void rec_func(int k, int value) {
        if (k == N + 1 ) {
            if (value == S)
                ans++;
        } else {
            // k 번째 원소를 포함할 지 결정
            rec_func(k + 1, value + nums[k]);
            rec_func(k + 1, value);
        }
    }

    private static void input() {
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++)
            nums[i] = sc.nextInt();
    }
}
