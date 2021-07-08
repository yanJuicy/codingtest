package pooshapman.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(solve(nums));
    }

    private static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtracking(result, list, nums);

        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            //System.out.println(result);
        } else {
            for (int num : nums) {
                if (list.contains(num)) continue;
                list.add(num);
                backtracking(result, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
