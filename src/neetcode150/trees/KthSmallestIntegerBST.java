package neetcode150.trees;

/**
 * @author Created by sunjy on 4/27/25
 */
public class KthSmallestIntegerBST {

    private int count = 0;
    private int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return val;
    }

    private void dfs(TreeNode treeNode, int k) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, k);
        count++;
        if (count == k) {
            val = treeNode.val;
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
