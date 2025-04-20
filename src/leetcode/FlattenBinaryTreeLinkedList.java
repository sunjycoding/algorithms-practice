package leetcode;

/**
 * 114. Flatten Binary Tree to Linked List
 *
 * @author Created by sunjy on 4/19/25
 */
public class FlattenBinaryTreeLinkedList {

    //  I recursively flatten the left and right subtrees first (post-order),
    //  then attach the left subtree to the right,
    //  and connect the original right subtree to the end of the new right chain.

    //  Time O(n)
    //  Space O(n)
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        current.right = right;
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
