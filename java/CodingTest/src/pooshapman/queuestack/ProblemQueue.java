package pooshapman.queuestack;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class ProblemQueue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(solve(root));
    }

    private static List<List<Integer>> solve(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean traverse = true;
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> res = new ArrayList<>();
            while (len-- > 0) {
                TreeNode cur = q.poll();
                if (traverse)
                    res.add(cur.val);
                else
                    res.add(0, cur.val);

                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            result.add(res);
            traverse = !traverse;
        }
        return result;
    }
}
