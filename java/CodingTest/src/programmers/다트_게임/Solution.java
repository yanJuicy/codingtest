package programmers.다트_게임;

import java.util.Arrays;

public class Solution {

    public int solution(String dartResult) {
        int[] counts = new int[3];

        int num = 0;
        int idx = 0;
        for (char c : dartResult.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num *= 10;
                num += c - '0';
                continue;
            }
            if (c == '*') {
                counts[--idx] *= 2;
                if (idx != 0) {
                    counts[idx - 1] *= 2;
                }
                idx++;
                continue;
            }
            if (c == '#') {
                idx--;
                counts[idx++] *= -1;
                continue;
            }
            counts[idx] = num;
            counts[idx] = c == 'D' ? counts[idx] * counts[idx] : counts[idx];
            counts[idx] = c == 'T' ? counts[idx] * counts[idx] * counts[idx] : counts[idx];
            idx++;
            num = 0;
        }

        int answer = Arrays.stream(counts).sum();
        return answer;
    }
}
