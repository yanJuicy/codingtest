package programmers.약수의_개수와_덧셈;

public class Solution {

    public int solution(int left, int right) {
        int answer = 0;

        for (int num = left; num <= right; num++) {
            if (isSquare(num)) {
                answer -= num;
            } else {
                answer += num;
            }
        }

        return answer;
    }

    private boolean isSquare(int num) {
        int divisor = 1;
        while (divisor * divisor < num) {
            divisor++;
        }
        if (divisor * divisor == num) {
            return true;
        }
        return false;
    }
}
