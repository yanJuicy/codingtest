package programmers.정수_제곱근_판별;

public class Solution {

    public long solution(long n) {
        long base = 1;
        while (base * base < n) {
            base++;
        }

        long answer = -1;
        if (base * base == n) {
            answer = (base + 1) * (base + 1);
        }

        return answer;
    }
}
