package neetcode150.trees;

/**
 * @author Created by sunjy on 5/4/25
 */
public class DiameterBinaryTree {

    //  Does the diameter count nodes or edges? For example, is the path 1-2-3 considered length 3 or 2?
    //  Can root be null? If so, what should the diameter be in that case?
    //  Can node values be negative? And is the tree balanced, or arbitrary?

    //  I use post-order DFS to compute
    //  the height of left and right subtrees for each node.
    //  At each node, I update the diameter as left + right,
    //  which represents the longest path through that node.

    //  Time O(n)
    //  Space O(h)
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = depth(treeNode.left);
        int right = depth(treeNode.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
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
