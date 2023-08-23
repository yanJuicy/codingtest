package programmers.이상한_문자_만들기;

public class Solution {

    public String solution(String s) {
        String[] words = s.split("");
        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (cnt % 2 == 0) {
                sb.append(word.toUpperCase());
            } else {
                sb.append(word.toLowerCase());

            }
            cnt = word.contains(" ") ? 0 : cnt + 1;
        }

        String answer = sb.toString();
        return answer;
    }

}
