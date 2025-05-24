package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class InvertBinaryTree {

    //  Can the input tree be null?
    //  Should we modify the original tree or return a new one?

    //  I use recursion.
    //  For each node,
    //  I recursively invert its left and right subtrees, then swap them and return the node.
    //  This is a bottom-up approach to invert the entire tree.

    //  Time O(n)
    //  Space O(1)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
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
