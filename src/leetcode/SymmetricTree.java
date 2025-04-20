package leetcode;

/**
 * 101. Symmetric Tree
 *
 * @author Created by sunjy on 4/18/25
 */
public class SymmetricTree {

    //  I define a helper function isSymmetric(left, right) to check if two subtrees are mirror images.
    //  If both are null, return true; if only one is null or values don’t match, return false.
    //  Then I recursively compare left.left with right.right, and left.right with right.left.

    //  Time O(n)
    //  Space O(h)
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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