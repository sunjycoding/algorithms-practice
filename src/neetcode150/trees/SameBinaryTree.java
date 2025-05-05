package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class SameBinaryTree {

    //  I use DFS to compare both structure and values of the trees.
    //  If any mismatch or one side is null, I return false;
    //  otherwise, I recurse on both sides and return true if all match

    //  Time O(n)
    //  Space O(h)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
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
