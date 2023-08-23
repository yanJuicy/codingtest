package programmers.숫자의_표현;

public class Solution {

    public int solution(int n) {
        int l = 1;
        int r = 2;
        int sum = l + r;

        int answer = 1;
        while (l < r) {
            while (sum < n) {
                sum += ++r;
            }
            if (sum == n) {
                answer++;
            }
            sum -= l++;
        }

        return answer;
    }
}
