package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 *
 * @author Created by sunjy on 5/16/25
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            ans.add(new ArrayList<>(path));
        }
        dfs(node.left, target, path, ans);
        dfs(node.right, target, path, ans);
        path.remove(path.size() - 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
