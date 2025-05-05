package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class LowestCommonAncestorBinarySearchTree {

    //  Since this is a BST, I use its property to prune the search:
    //  If both p and q are smaller than the current node, I search left.
    //  If both are larger, I search right.
    //  If they diverge (one on each side), then the current node is their lowest common ancestor

    //  Time O(h)
    //  Space O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
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
