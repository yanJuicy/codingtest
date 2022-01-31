package baekjoon._15970;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static List[] list;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        for (List<Integer> l : list) {
            Collections.sort(l);

            for (int i = 0; i < l.size(); i++) {
                if (i == 0) cnt += l.get(i + 1) - l.get(i);
                else if (i == l.size() - 1) cnt += l.get(i) - l.get(i - 1);
                else cnt += Math.min(l.get(i + 1) - l.get(i), l.get(i) - l.get(i - 1));
            }
        }
        System.out.println(cnt);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        list = new List[N + 1];

        for (int i=0; i<N + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int c = sc.nextInt();
            list[c].add(x);
        }
        sc.close();
    }
}
