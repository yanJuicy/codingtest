package pooshapman.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Basic_bfs01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(solve(root));
    }

    private static List<List<Integer>> solve(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean reverse = false;
        while (!q.isEmpty()) {
            int length = q.size();
            List<Integer> list = new ArrayList<>();
            while (length-- > 0) {
                TreeNode t = q.poll();

                if (reverse) {
                    list.add(0, t.val);
                } else {
                    list.add(t.val);
                }

                if (t.left != null) {
                    q.offer(t.left);
                }

                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            reverse = !reverse;
            result.add(list);
        }

        return result;
    }
}

class TreeNode {
    int val;

    TreeNode left, right;
    public TreeNode(int val) {
        this.val  = val;
    }
}

