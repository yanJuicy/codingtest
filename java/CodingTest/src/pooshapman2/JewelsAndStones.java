package pooshapman2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(solve(jewels, stones));
    }

    public static int solve(String jew, String stones) {
        int result = 0;

        Set<Character> set = new HashSet<>();
        for (int i=0; i<jew.toCharArray().length; i++) {
            set.add(jew.toCharArray()[i]);
        }

        for (int i=0; i<stones.toCharArray().length; i++) {
            if (set.contains(stones.toCharArray()[i]))
                result++;
        }

        return result;
    }

}
