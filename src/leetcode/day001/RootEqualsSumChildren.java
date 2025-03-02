package leetcode.day001;

/**
 * 2236. Root Equals Sum of Children
 *
 * @author Created by sunjy on 3/1/25
 */
public class RootEqualsSumChildren {

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
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
