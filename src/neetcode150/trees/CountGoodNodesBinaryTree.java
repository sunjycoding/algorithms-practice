package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class CountGoodNodesBinaryTree {

    //  I use pre-order DFS to traverse the tree
    //  while tracking the maximum value along the path from root to the current node.
    //  If the current node's value is greater than or equal to this max,
    //  it’s a 'good node' and I increment the counter.

    //  Time O(n)
    //  Space O(h)
    private int count = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode treeNode, int max) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.val >= max) {
            count++;
        }
        max = Math.max(max, treeNode.val);
        dfs(treeNode.left, max);
        dfs(treeNode.right, max);
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
