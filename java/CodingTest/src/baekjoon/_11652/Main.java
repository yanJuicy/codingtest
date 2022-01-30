package baekjoon._11652;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static long nums[];

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(nums);
        long mode = nums[0];
        int modeCnt = 1, curCnt = 1;

        for (int i = 1; i < N; i++) {
            if (nums[i] == nums[i-1]) curCnt++;
            else curCnt = 1;
            if (modeCnt < curCnt) {
                mode = nums[i];
            }
        }

        System.out.println(mode);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextLong();
        }
        sc.close();
    }
}
