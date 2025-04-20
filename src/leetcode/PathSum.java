package leetcode;

/**
 * 112. Path Sum
 *
 * @author Created by sunjy on 4/18/25
 */
public class PathSum {

    //  I use DFS to traverse the tree.
    //  At each node, I subtract its value from targetSum.
    //  If I reach a leaf and the remaining sum is zero, then a valid path exists.

    //  Time O(n)
    //  Space O(h)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
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
