package programmers.두_개_뽑아서_더하기;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        int[] answer = set.stream().sorted().mapToInt(i -> i).toArray();
        return answer;
    }
}
