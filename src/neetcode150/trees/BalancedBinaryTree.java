package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class BalancedBinaryTree {

    //  Just to confirm, is the definition of 'balanced' here that for every node, the height difference between its left and right subtree is at most 1
    //  Is an empty tree considered balanced?
    //  Just to clarify — this problem is purely structural, correct? The node values don’t affect whether the tree is balanced?

    //  I use post-order DFS to calculate the height of subtrees and simultaneously check if they are balanced.
    //  If I find any unbalanced subtree, I return -1 immediately to short-circuit further computation.

    //  Time O(n)
    //  Space O(h)
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = dfs(treeNode.left);
        int right = dfs(treeNode.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(right - left) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
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
