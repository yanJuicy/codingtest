package programmers.크레인_인형뽑기_게임;

import java.util.Stack;

public class Solution {

    public int solution(int[][] board, int[] moves) {

        Stack<Integer> bucket = new Stack<>();

        int answer = 0;

        for (int move : moves) {
            move--;
            int doll = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][move] != 0) {
                    doll = board[i][move];
                    board[i][move] = 0;
                    break;
                }
            }
            if (doll == 0) {
                continue;
            }

            if (!bucket.isEmpty() && bucket.peek() == doll) {
                bucket.pop();
                answer += 2;
                continue;
            }
            bucket.push(doll);
        }

        return answer;
    }
}
