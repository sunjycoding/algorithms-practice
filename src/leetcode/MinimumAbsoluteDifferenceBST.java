package leetcode;

/**
 * 530. Minimum Absolute Difference in BST
 *
 * @author Created by sunjy on 4/20/25
 */
public class MinimumAbsoluteDifferenceBST {

    //  Since in-order traversal of a BST gives us a sorted sequence,
    //  we only need to compare adjacent values to find the minimum absolute difference.
    //  So we maintain a prev variable and update minDiff during traversal.

    //  Time O(n)
    //  Space O(h)
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inOrderTraversal(node.right);
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
