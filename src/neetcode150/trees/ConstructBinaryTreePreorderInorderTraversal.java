package neetcode150.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by sunjy on 4/30/25
 */
public class ConstructBinaryTreePreorderInorderTraversal {

    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInorder = inorderIndexMap.get(rootVal);
        int leftSize = rootIndexInorder - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndexInorder - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndexInorder + 1, inEnd);

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
