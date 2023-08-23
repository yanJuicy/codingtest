package baekjoon._1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static int n;
    private static int[] a;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Stack<Integer> st = new Stack<>();
        st.add(0);
        StringBuilder sb = new StringBuilder();
        int value = 1;
        for (int i = 0; i < n; i++) {
            int target = a[i];
            int cur = st.peek();

            if (cur <= target) {
                while (value <= target) {
                    st.add(value);
                    value++;
                    sb.append('+').append('\n');
                }
                st.pop();
                sb.append('-').append('\n');
            } else {
                sb.replace(0, sb.length(), "NO");
                break;
            }
        }

        System.out.println(sb.toString());
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
    }

}
