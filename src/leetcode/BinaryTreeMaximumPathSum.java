package leetcode;

/**
 * 124. Binary Tree Maximum Path Sum
 *
 * @author Created by sunjy on 4/20/25
 */
public class BinaryTreeMaximumPathSum {

    //  I use post-order DFS to compute the max path sum through each node.
    //  I calculate the best one-sided path to return upward and update the global max
    //  when both left and right are used at a node.

    //  Time O(n)
    //  Space O(h)
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        int currentPath = node.val + left + right;

        maxSum = Math.max(maxSum, currentPath);

        return node.val + Math.max(left, right);
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
