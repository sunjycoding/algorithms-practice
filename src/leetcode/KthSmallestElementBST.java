package leetcode;

/**
 * 230. Kth Smallest Element in a BST
 *
 * @author Created by sunjy on 4/20/25
 */
public class KthSmallestElementBST {

    //  Since an in-order traversal of a BST gives sorted order,
    //  I keep a counter while traversing. When the counter hits k,
    //  I record that node’s value as the result. I do left, visit current, then right.

    //  Time O(n)
    //  Space O(h)
    private int count = 0;
    private int result = 0;

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
