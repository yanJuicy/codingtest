package programmers.같은_숫자는_싫어;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != st.peek()) {
                st.add(arr[i]);
            }
        }
        int[] answer = new int[st.size()];
        int idx = st.size() - 1;
        while (!st.empty()) {
            answer[idx--] = st.pop();
        }

        return answer;
    }
}
