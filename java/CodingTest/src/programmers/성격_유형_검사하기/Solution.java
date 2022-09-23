package programmers.성격_유형_검사하기;

public class Solution {

    private int[] rt = new int[2];
    private int[] cf = new int[2];
    private int[] jm = new int[2];
    private int[] an = new int[2];

    public String solution(String[] survey, int[] choices) {

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];

            int c = choices[i];
            if (c == 4) {
                continue;
            } else if (c < 4) {
                add(s.charAt(0), 4 - c);
            } else {
                add(s.charAt(1), c - 4);
            }
        }

        String answer = calculate();
        return answer;
    }

    private String calculate() {
        StringBuilder sb = new StringBuilder();
        if (rt[0] >= rt[1]) {
            sb.append('R');
        } else {
            sb.append('T');
        }
        if (cf[0] >= cf[1]) {
            sb.append('C');
        } else {
            sb.append('F');
        }
        if (jm[0] >= jm[1]) {
            sb.append('J');
        } else {
            sb.append('M');
        }
        if (an[0] >= an[1]) {
            sb.append('A');
        } else {
            sb.append('N');
        }

        return sb.toString();
    }

    private void add(char type, int point) {
        switch (type) {
            case 'R':
                rt[0] += point;
                break;
            case 'T':
                rt[1] += point;
                break;
            case 'C':
                cf[0] += point;
                break;
            case 'F':
                cf[1] += point;
                break;
            case 'J':
                jm[0] += point;
                break;
            case 'M':
                jm[1] += point;
                break;
            case 'A':
                an[0] += point;
                break;
            case 'N':
                an[1] += point;
                break;
        }
    }

}
