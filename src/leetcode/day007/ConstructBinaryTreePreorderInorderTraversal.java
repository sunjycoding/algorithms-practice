package leetcode.day007;

import java.util.HashMap;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * @author Created by sunjy on 3/14/25
 */
public class ConstructBinaryTreePreorderInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, inorderMap, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, HashMap<Integer, Integer> inorderMap,
                           int preIndex, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(rootVal);

        int leftSize = inIndex - inLeft;

        root.left = build(preorder, inorderMap, preIndex + 1, inLeft, inIndex - 1);
        root.right = build(preorder, inorderMap, preIndex + 1 + leftSize, inIndex + 1, inRight);

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
