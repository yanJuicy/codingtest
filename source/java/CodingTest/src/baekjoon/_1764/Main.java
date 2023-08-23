package baekjoon._1764;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int N, M;
    private static String[] A, B;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(B);
        int cnt = 0;
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (Arrays.binarySearch(B, A[i]) >= 0) {
                cnt++;
                resultList.add(A[i]);
            }
        }
        Collections.sort(resultList);
        sb.append(cnt + "\n");
        for (String s : resultList)
            sb.append(s + "\n");
        System.out.println(sb.toString());
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new String[N];
        B = new String[M];
        for (int i = 0; i < N; i++) A[i] = sc.next();
        for (int i = 0; i < M; i++) B[i] = sc.next();
        sc.close();
    }
}
