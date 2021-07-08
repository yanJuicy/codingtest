package pooshapman.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println(solve(n, k));

    }

    private static List<List<Integer>> solve(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(result, list, n, k, 1);

        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i=start; i<=n; i++) {
                list.add(i);
                backtracking(result, list, n, k, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }
}
