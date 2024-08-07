
import java.util.Scanner;

public class Main {

    private static String s;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int sum = 0;

        String[] a = s.split("-");

        for (int i = 0; i < a.length; i++) {
            int part = partSum(a[i]);
            if (i == 0) {
                sum += part;
            } else {
                sum -= part;
            }
        }

        System.out.println(sum);
    }

    private static int partSum(String string) {
        String[] a = string.split("\\+");

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Integer.parseInt(a[i]);
        }

        return sum;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
    }

}
