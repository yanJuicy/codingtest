package programmers.예산;

import java.util.Arrays;

public class Solution {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int answer = 0;
        for (int i : d) {
            budget -= i;
            if (budget < 0)
                break;
            answer++;
        }
        return answer;
    }
}
