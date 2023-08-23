package programmers.완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String p : completion) {
            int count = map.get(p);
            map.put(p, count - 1);
        }

        String answer = "";
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}
