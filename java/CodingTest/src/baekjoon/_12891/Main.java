package baekjoon._12891;

import java.util.Scanner;

public class Main {

    private static int s, p;
    private static String str;
    private static int a, c, g, t;
    private static int ca, cc, cg, ct;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        int start = 0;
        int end = 0;

        while (end <= s) {
            if (end - start == p) {
                if (ca >= a && cc >= c && cg >= g && ct >= t) {
                    cnt++;
                }
                minus(str.charAt(start));
                start++;
            }
            if (end == s)
                break;

            plus(str.charAt(end));
            end++;
        }

        System.out.println(cnt);
    }

    private static void plus(char c) {
        switch (c) {
            case 'A':
                ca++;
                break;
            case 'C':
                cc++;
                break;
            case 'G':
                cg++;
                break;
            case 'T':
                ct++;
                break;
        }
    }

    private static void minus(char c) {
        switch (c) {
            case 'A':
                ca--;
                break;
            case 'C':
                cc--;
                break;
            case 'G':
                cg--;
                break;
            case 'T':
                ct--;
                break;
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        p = sc.nextInt();
        str = sc.next();
        a = sc.nextInt();
        c = sc.nextInt();
        g = sc.nextInt();
        t = sc.nextInt();
    }

}
