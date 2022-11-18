package programmers.제일_작은_수_제거하기;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[] {-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();

        int[] answer = Arrays.stream(arr).filter(i -> i != min).toArray();
        return answer;
    }
}
