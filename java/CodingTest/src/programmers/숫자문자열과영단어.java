package programmers;

public class 숫자문자열과영단어 {

    public int solution(String s) {
        String[] strs = {"zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"};

        int answer = 0;
        for (int i=0; i<10; i++) {
            s = s.replaceAll(strs[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);

        return answer;
    }



    public static void main(String[] args) {
        System.out.println((new 숫자문자열과영단어().solution("one4seveneight")));
    }
}
