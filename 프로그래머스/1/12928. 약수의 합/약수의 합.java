class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int num = 1; num <= n; num ++) {
            if (n % num == 0) {
                answer += num;
            }
        }
        
        return answer;
    }
}