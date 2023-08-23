package programmers.폰켓몬;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int[] nums) {
        Set<Integer> ponketmon = new HashSet<>();
        ponketmon.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        int answer = Math.min(ponketmon.size(), nums.length / 2);
        return answer;
    }
}
