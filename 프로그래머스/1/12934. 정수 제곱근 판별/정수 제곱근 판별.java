class Solution {
    public long solution(long n) {
        long answer = 0;
        
        while (answer * answer < n) {
            answer++;
        }
        
        if (answer * answer == n) {
            return (answer + 1) * (answer + 1);
        }
        
        return -1;
    }
}