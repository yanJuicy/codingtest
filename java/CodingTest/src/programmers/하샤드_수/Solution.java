package programmers.하샤드_수;

public class Solution {
    public boolean solution(int x) {
        int temp = x;
        int sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        boolean answer = true;
        if (x % sum != 0) {
            answer = false;
        }
        return answer;
    }
}
