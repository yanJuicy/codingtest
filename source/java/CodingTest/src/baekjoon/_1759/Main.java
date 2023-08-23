package baekjoon._1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int l, c;
    static String[] a;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder password = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve(0, 0);
        System.out.println(sb.toString());
    }

    private static void solve(int len, int n) {
        if (len == l) {
            if (validate())
                sb.append(password.toString()).append("\n");
        } else {
            for (int i = n; i < c; i++) {
                password.append(a[i]);
                solve(len + 1, i + 1);
                password.delete(password.length() - 1, password.length());
            }
        }
    }

    private static boolean validate() {
        String str = password.toString();
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e'|| c == 'i' || c == 'o' || c == 'u')
                cnt++;
        }
        return cnt >= 1 && str.length() - cnt >= 2;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        a = new String[c];
        for (int i = 0; i < c; i++)
            a[i] = sc.next();
        Arrays.sort(a);
        sc.close();
    }
}
