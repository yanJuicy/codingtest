package programmers.자연수_뒤집어_배열로_만들기;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add((int) (n % 10));
            n /= 10;
        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

}
