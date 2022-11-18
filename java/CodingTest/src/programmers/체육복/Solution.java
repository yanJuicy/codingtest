package programmers.체육복;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        Set<Integer> reserveSet = new HashSet<>();
        reserveSet.addAll(Arrays.stream(reserve).boxed().collect(Collectors.toList()));

        Set<Integer> lostSet = new HashSet<>();
        lostSet.addAll(Arrays.stream(lost).boxed().collect(Collectors.toList()));

        for (int i : lost) {
            if (reserveSet.contains(i)) {
                reserveSet.remove(i);
                lostSet.remove(i);
            }
        }

        for (int i : lostSet) {
            if (reserveSet.contains(i - 1)) {
                reserveSet.remove(i - 1);
            } else if (reserveSet.contains(i + 1)) {
                reserveSet.remove(i + 1);
            } else {
                answer--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(5, new int[] {2, 4}, new int[] {3});
    }
}
