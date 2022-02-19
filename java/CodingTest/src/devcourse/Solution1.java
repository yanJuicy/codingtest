package devcourse;

import java.util.Arrays;

public class Solution1 {

    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = -1;
        int result = Integer.MAX_VALUE;

        for (int cand = 0; cand <= 255; cand++) {
            int a = 0;
            for (int i = 0; i < arr.length && arr[i] < cand; i++) {
                a++;
            }
            int b = arr.length - a;

            int sum = Math.abs(a - b);
            if (result > sum) {
                result = sum;
                answer = cand;
            }
        }
        return answer;
    }

}