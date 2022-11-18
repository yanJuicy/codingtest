package programmers._3진법_뒤집기;

public class Solution {

    public int solution(int n) {
        String s = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();

        int answer = Integer.parseInt(s, 3);
        return answer;
    }

}
