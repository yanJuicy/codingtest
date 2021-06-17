package thisiscodingtest.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[] array = new int[n];
        st = br.readLine().split(" ");
        int index = 0;
        for (String s : st) {
            array[index++] = Integer.parseInt(s);
        }
        Arrays.sort(array);
        int left = 0;
        int right = array[n-1];

        int result = 0;
        while (left <= right) {
            long sum = 0;
            int mid = (left + right) / 2;

            for (int num : array) {
                if (num > mid) {
                    sum += num - mid;
                }
            }

            if (sum >= m) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
        br.close();
    }

}
