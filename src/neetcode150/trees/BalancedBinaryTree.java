package neetcode150.trees;

/**
 * @author Created by sunjy on 4/27/25
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = dfs(treeNode.left);
        int rightDepth = dfs(treeNode.right);
        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }
        if (Math.abs(rightDepth - leftDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
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
