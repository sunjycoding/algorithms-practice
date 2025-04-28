package neetcode150.trees;

/**
 * @author Created by sunjy on 4/27/25
 */
public class ValidBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode treeNode, int min, int max) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.val >= max || treeNode.val <= min) {
            return false;
        }
        return isValidBST(treeNode.left, min, treeNode.val) && isValidBST(treeNode.right, treeNode.val, max);
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
