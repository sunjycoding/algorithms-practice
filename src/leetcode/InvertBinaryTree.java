package leetcode;

/**
 * 226. Invert Binary Tree
 *
 * @author Created by sunjy on 4/18/25
 */
public class InvertBinaryTree {

    //  I use recursion to invert the left and right subtrees of each node, then swap them.
    //  It’s essentially a post-order traversal.

    //  Time O(n)
    //  Space O(h)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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
