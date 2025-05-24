package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class KthSmallestIntegerBST {

    //  Is it guaranteed that k is within the total number of nodes?

    //  I use in-order traversal because it gives a sorted sequence in a BST.
    //  I maintain a counter while traversing, and return the k-th node when the counter reaches k.

    //  Time O(n)
    //  Space O(h)
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode treeNode, int k) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, k);
        count++;
        if (count == k) {
            result = treeNode.val;
            return;
        }
        dfs(treeNode.right, k);
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
