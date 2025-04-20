package leetcode;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * @author Created by sunjy on 4/18/25
 */
public class MaximumDepthBinaryTree {

    //  I use recursion to get the depth of left and right subtrees, and take max(left, right) + 1 at each node.
    //  It’s a classic post-order traversal.

    //  Time O(n)
    //  Space O(h)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
