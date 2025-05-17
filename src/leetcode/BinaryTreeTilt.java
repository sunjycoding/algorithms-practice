package leetcode;

/**
 * 563. Binary Tree Tilt
 *
 * @author Created by sunjy on 5/16/25
 */
public class BinaryTreeTilt {

    private int tilt = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return tilt;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftSum = dfs(treeNode.left);
        int rightSum = dfs(treeNode.right);
        tilt += Math.abs(rightSum - leftSum);
        return leftSum + rightSum + treeNode.val;
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
