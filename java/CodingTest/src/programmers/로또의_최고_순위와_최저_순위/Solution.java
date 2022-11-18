package programmers.로또의_최고_순위와_최저_순위;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {
        int highHit = 0;
        int lowHit = 0;
        int unknowns = 0;
        int count = 0;

        Set<Integer> winSet = new HashSet<>();
        for (int win_num : win_nums) {
            winSet.add(win_num);
        }

        for (int lotto : lottos) {
            if (lotto == 0) {
                unknowns++;
            }
            if (winSet.contains(lotto)) {
                count++;
            }
        }

        highHit = count + unknowns > 6 ? 6 : count + unknowns;
        lowHit = count;
        int[] rank = {6, 5, 4, 3, 2};

        int highRank = 6;
        int lowRank = 6;
        for (int i = 0; i < rank.length; i++) {
            if (highHit == rank[i]) {
                highRank = i + 1;
            }
            if (lowHit == rank[i]) {
                lowRank = i + 1;
            }
        }

        int[] answer = {highRank, lowRank};
        return answer;
    }
}
