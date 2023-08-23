package baekjoon._10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int[] a;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        radixSort(5);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void radixSort(int maxSize) {
        int[] output = new int[a.length];
        int jarisu = 1;
        int count = 0;

        while (count != maxSize) // 최대 자리수 만큼 반복
        {
            int[] bucket = new int[10];
            for (int i = 0; i < a.length; i++) {
                bucket[(a[i] / jarisu) % 10]++; // 일의 자리 부터 시작
            }
            for (int i = 1; i < 10; i++) { // 합배열을 이용하여 index 계산
                bucket[i] += bucket[i - 1];
            }
            for (int i = a.length - 1; i >= 0; i--) { // 현재 자리수 기준으로 정렬하기
                output[bucket[(a[i] / jarisu % 10)] - 1] = a[i];
                bucket[(a[i] / jarisu) % 10]--;
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = output[i]; // 다음 자리 수 이동을 위해 현재 자리수 기준 정렬 데이터 저장
            }
            jarisu = jarisu * 10; // 자리수 증가
            count++;
        }
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

}
