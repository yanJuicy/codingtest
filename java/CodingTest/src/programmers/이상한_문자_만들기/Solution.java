package programmers.이상한_문자_만들기;

public class Solution {

    public String solution(String s) {
        String[] words = s.split("");
        String answer = "";
        int cnt = 0;

        for (String word : words) {
            answer += cnt % 2 == 0 ? word.toUpperCase() : word.toLowerCase();
            cnt = word.contains(" ") ? 0 : cnt + 1;
        }

        return answer;
    }

}
