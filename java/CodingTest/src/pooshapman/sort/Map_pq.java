package pooshapman.sort;

import java.util.*;

public class Map_pq {

    public static void main(String[] args) {
        String[] words= {"a", "b", "c", "a", "b", "c", "a"};
        int k = 2;
        System.out.println(solve(words, k));
    }

    private static List<String> solve(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        while (k-- > 0) {
            result.add(pq.poll().getKey());
        }

        return result;
    }


}
