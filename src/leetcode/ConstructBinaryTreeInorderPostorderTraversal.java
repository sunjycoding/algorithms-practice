package leetcode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author Created by sunjy on 4/19/25
 */
public class ConstructBinaryTreeInorderPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

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
