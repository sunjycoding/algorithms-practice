package leetcode;

/**
 * 222. Count Complete Tree Nodes
 *
 * @author Created by sunjy on 4/19/25
 */
public class CountCompleteTreeNodes {

    //  Since this is a complete binary tree, I compare the left and right subtree depths.
    //  If they’re equal, the left subtree is a full binary tree and we can directly compute its node count.
    //  Otherwise, we recurse on the left or right.
    //  This avoids visiting all nodes and improves performance.

    //  Time O(log² n)
    //  Space O(log n)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
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
