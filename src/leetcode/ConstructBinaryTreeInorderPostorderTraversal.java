package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author Created by sunjy on 4/19/25
 */
public class ConstructBinaryTreeInorderPostorderTraversal {

    //  The last element in postorder is the root of the current subtree.
    //  Find that value’s index in inorder to divide left and right subtree.
    //  Recursively build right subtree first, then left, because postorder is L → R → Root.

    //  Time O(n)
    //  Space O(1)
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInorder = inorderIndexMap.get(rootVal);
        int leftSize = rootIndexInorder - inStart;

        root.right = build(postorder, postStart + leftSize, postEnd - 1,
                inorder, rootIndexInorder + 1, inEnd);

        root.left = build(postorder, postStart, postStart + leftSize - 1,
                inorder, inStart, rootIndexInorder - 1);

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
