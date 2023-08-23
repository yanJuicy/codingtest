package programmers.숫자_문자열과_영단어;

public class Solution {

    public int solution(String s) {
        String[] strs =
                {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(strs[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);

        return answer;
    }
}
