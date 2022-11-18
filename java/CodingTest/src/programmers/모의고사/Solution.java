package programmers.모의고사;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int hit[] = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) {
                hit[0]++;
            }
            if (answers[i] == p2[i % p2.length]) {
                hit[1]++;
            }
            if (answers[i] == p3[i % p3.length]) {
                hit[2]++;
            }
        }
        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < hit.length; i++) {
            if (max == hit[i]) {
                list.add(i + 1);
            }
        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
