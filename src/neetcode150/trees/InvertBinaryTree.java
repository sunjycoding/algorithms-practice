package neetcode150.trees;

/**
 * @author Created by sunjy on 4/27/25
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        dfs(left);
        dfs(right);
        treeNode.left = right;
        treeNode.right = left;
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
