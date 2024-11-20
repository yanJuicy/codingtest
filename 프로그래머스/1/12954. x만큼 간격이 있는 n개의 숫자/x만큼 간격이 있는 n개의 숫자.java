import java.util.List;
import java.util.ArrayList;

class Solution {
    public long[] solution(int x, int n) {
        List<Long> list = new ArrayList<>() {
            {
                long num = x;
                for (int i = 0; i < n; i++) {
                    add(num);
                    num += x;
                }
            }    
        };
        
        long[] answer = new long[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}