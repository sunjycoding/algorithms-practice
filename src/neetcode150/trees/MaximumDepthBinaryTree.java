package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class MaximumDepthBinaryTree {

    //  I use post-order traversal.
    //  I recursively compute the max depth of the left and right subtrees,
    //  then return the larger one plus 1.
    //  Null nodes return 0 as the base case.

    //  Time O(n)
    //  Space O(h)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
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
