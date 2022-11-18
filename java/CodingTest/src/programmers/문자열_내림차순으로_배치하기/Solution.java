package programmers.문자열_내림차순으로_배치하기;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public String solution(String s) {
        String[] alphabets = s.split("");
        Arrays.sort(alphabets, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String alphabet : alphabets) {
            sb.append(alphabet);
        }
        String answer = sb.toString();
        return answer;
    }

}
