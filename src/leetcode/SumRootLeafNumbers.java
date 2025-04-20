package leetcode;

/**
 * 129. Sum Root to Leaf Numbers
 *
 * @author Created by sunjy on 4/19/25
 */
public class SumRootLeafNumbers {

    //  I use DFS and pass down the accumulated path value in each recursive call.
    //  Once I reach a leaf node, I return the complete number. Otherwise, I sum the values from both subtrees.

    //  Time O(n)
    //  Space O(h)
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
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
