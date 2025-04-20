package leetcode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * @author Created by sunjy on 4/19/25
 */
public class LowestCommonAncestorBinaryTree {

    //  I use post-order recursion.
    //  If the current node is either p or q, I return it directly.
    //  If both left and right return non-null, the current node is the LCA.
    //  Otherwise, I return the non-null child.

    //  Time O(n)
    //  Space O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
