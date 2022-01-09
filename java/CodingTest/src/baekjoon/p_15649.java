package baekjoon;

import java.util.Scanner;

public class p_15649 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static boolean[] nums = new boolean[8];

    static void solve(int n, int m, int step) {
        if (step == m) {
            for (int i=0; i<n; i++)
                if (nums[i])
                    sb.append(i+1).append(" ");
            sb.append('\n');
        } else {
            for (int i=step; i<n; i++) {
                nums[i] = true;
                solve(n, m, step + 1);
                nums[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        solve(n, m, 0);
        System.out.println(sb.toString());

    }
}
