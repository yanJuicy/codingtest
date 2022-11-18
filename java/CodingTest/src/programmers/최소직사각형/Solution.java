package programmers.최소직사각형;

public class Solution {

    public int solution(int[][] sizes) {
        int max_width = 0;
        int max_height = 0;
        for (int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];

            max_width = Math.max(max_width, Math.max(width, height));
            max_height = Math.max(max_height, Math.min(width, height));
        }

        int answer = max_width * max_height;
        return answer;
    }

}
