package baekjoon._1472;

import java.util.Scanner;

public class Main {

    private static String n;
    private static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < a.length; i++) {
            int max = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[max]) {
                    max = j;
                }
            }
            if (a[i] < a[max]) {
                int temp = a[i];
                a[i] = a[max];
                a[max] = temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLine();
        a = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            a[i] = Integer.parseInt(n.substring(i, i + 1));
        }
    }
}
