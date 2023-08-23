package programmers.시저_암호;

public class Solution {

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                continue;
            }
            char upperOrLower = 'A';

            if (Character.isLowerCase(c)) {
                upperOrLower = 'a';
            }
            int step = (c - upperOrLower + n) % 26;
            sb.append((char) (upperOrLower + step));
        }

        String answer = sb.toString();
        return answer;
    }
}
