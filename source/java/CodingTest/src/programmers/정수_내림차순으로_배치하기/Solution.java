package programmers.정수_내림차순으로_배치하기;

import java.util.Arrays;

public class Solution {

    public long solution(long n) {
        String s = n + "";
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        char[] reverseArray = new char[sArray.length];
        for (int i = 0; i < sArray.length; i++) {
            reverseArray[sArray.length - 1 - i] = sArray[i];
        }

        long answer = Long.parseLong(String.valueOf(reverseArray));
        return answer;
    }

}
