import java.util.Scanner;

public class Main {

    private static int n, m;
    private static int a[];
    private static boolean check[];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        rec(0);
        System.out.println(sb.toString());
    }

    private static void rec(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                if (check[i]) {
                    continue;
                }
                a[k] = i;
                check[i] = true;

                rec(k + 1);

                a[k] = 0;
                check[i] = false;
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[m];
        check = new boolean[n + 1];
        sc.close();
    }

}
