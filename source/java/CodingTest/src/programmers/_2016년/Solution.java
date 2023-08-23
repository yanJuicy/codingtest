package programmers._2016년;

import java.util.Calendar;

public class Solution {

    public String solution(int a, int b) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, a - 1, b);
        String answer = calendar.getTime().toString().substring(0, 3).toUpperCase();
        return answer;
    }
}
