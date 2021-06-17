package pooshapman.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,5,5,5,5};
        int k = 2;

        List<Integer> result = solve(nums, k);

        System.out.println(result);
    }

    private static List<Integer> solve(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] list = new List[nums.length + 1];
        List<Integer> result = new ArrayList<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int key : map.keySet()) {
            int topFrequent = map.get(key);
            if (list[topFrequent] == null) {
                list[topFrequent] = new ArrayList<>();
            }
            list[topFrequent].add(key);
        }

        for (int i=list.length-1; i>=0; i--) {
            if (list[i] != null) {
                for (int j=0; j<list[i].size() && result.size() < k; j++) {
                    result.add(list[i].get(j));
                }
            }
        }

        return result;
    }

}
