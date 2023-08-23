package programmers.나누어_떨어지는_숫자_배열;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for (int n : arr) {
            if (n % divisor == 0) {
                list.add(n);
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        }

        Collections.sort(list);

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

}
