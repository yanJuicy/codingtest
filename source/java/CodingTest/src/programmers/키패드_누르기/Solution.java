package programmers.키패드_누르기;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution(int[] numbers, String hand) {
        Map<Integer, int[]> keypad = setKeypad();

        int[] positions = {'*', '#'};

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            String whichHand = pressThumb(number, positions, hand, keypad);
            sb.append(whichHand);

            if (whichHand.equals("L")) {
                positions[0] = number;
            } else {
                positions[1] = number;
            }
        }

        String answer = sb.toString();
        return answer;
    }

    private Map<Integer, int[]> setKeypad() {
        Map<Integer, int[]> keypad = new HashMap<>();
        keypad.put(1, new int[] {0, 0}); keypad.put(2, new int[] {0, 1}); keypad.put(3, new int[] {0, 2});
        keypad.put(4, new int[] {1, 0}); keypad.put(5, new int[] {1, 1}); keypad.put(6, new int[] {1, 2});
        keypad.put(7, new int[] {2, 0}); keypad.put(8, new int[] {2, 1}); keypad.put(9, new int[] {2, 2});
        keypad.put((int) '*', new int[] {3, 0}); keypad.put(0, new int[] {3, 1}); keypad.put((int) '#', new int[] {3, 2});
        return keypad;
    }

    private String pressThumb(int number, int[] positions, String hand, Map<Integer, int[]> keypad) {
        if (number == 1 || number == 4 || number == 7) {
            return "L";
        }
        if (number == 3 || number == 6 || number == 9) {
            return "R";
        }

        int[] leftPosition = keypad.get(positions[0]);
        int[] rightPosition = keypad.get(positions[1]);
        int[] numberPosition = keypad.get(number);

        int leftMove = getDistance(leftPosition, numberPosition);
        int rightMove = getDistance(rightPosition, numberPosition);

        if (leftMove == rightMove) {
            hand = hand.toUpperCase().substring(0, 1); 
        } else if (leftMove < rightMove) {
            hand = "L";
        } else {
            hand = "R";
        }

        return hand;
    }

    private int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

}
