package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class ConstructBinaryTreePreorderInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
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
