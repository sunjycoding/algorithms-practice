package leetcode;

/**
 * 100. Same Tree
 *
 * @author Created by sunjy on 4/18/25
 */
public class SameTree {

    //  I recursively traverse both trees together.
    //  At each node pair, I check if both are null (return true),
    //  only one is null (return false), or values differ (return false).
    //  Otherwise, I recursively check left and right subtrees.

    //  Time O(n)
    //  Space O(h)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
