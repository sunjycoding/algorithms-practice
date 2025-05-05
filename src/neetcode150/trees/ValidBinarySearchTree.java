package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class ValidBinarySearchTree {

    //  I use DFS to recursively check if each node falls within a valid range.
    //  The left subtree must be strictly less than the current node, and the right strictly greater.

    //  Time O(n)
    //  Space O(h)
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode treeNode, int min, int max) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.val >= max || treeNode.val <= min) {
            return false;
        }
        return dfs(treeNode.left, min, treeNode.val) && dfs(treeNode.right, treeNode.val, max);
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
