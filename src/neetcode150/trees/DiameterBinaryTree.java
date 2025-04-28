package neetcode150.trees;

/**
 * @author Created by sunjy on 4/27/25
 */
public class DiameterBinaryTree {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = dfs(treeNode.left);
        int right = dfs(treeNode.right);
        diameter = Math.max(diameter, left + right);
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
