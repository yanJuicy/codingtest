package programmers._1차_비밀지도;

public class Solution {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(arr1[i] | arr2[i]));
            while (sb.length() < n) {
                sb.insert(0, '0');
            }
            String mapRow = sb.toString();
            mapRow = mapRow.replaceAll("0", " ").replaceAll("1", "#");
            answer[i] = mapRow;
        }

        return answer;
    }
}
