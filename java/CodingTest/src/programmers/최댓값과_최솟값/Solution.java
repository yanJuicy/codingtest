package programmers.최댓값과_최솟값;

public class Solution {

    public String solution(String s) {
        String[] inputs = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String str : inputs) {
            int n = Integer.parseInt(str);
            if (max < n) {
                max = n;
            }
            if (min > n) {
                min = n;
            }
        }

        String answer = min + " " + max;
        return answer;
    }
}
