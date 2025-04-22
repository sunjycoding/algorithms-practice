package leetcode;

/**
 * 98. Validate Binary Search Tree
 *
 * @author Created by sunjy on 4/20/25
 */
public class ValidateBinarySearchTree {

    //  I’m using a recursive solution where each node must lie within a valid range.
    //  For the left child, the max bound is the current node’s value;
    //  for the right child, the min bound is the current node’s value.
    //  If any node violates this rule, we return false.

    //  Time O(n)
    //  Space O(h)
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max);
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
