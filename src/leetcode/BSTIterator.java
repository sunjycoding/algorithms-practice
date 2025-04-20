package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 173. Binary Search Tree Iterator
 *
 * @author Created by sunjy on 4/19/25
 */
public class BSTIterator {

    //  I use a stack to simulate in-order traversal.
    //  Each call to next() visits the next node and pushes the left branch of its right subtree,
    //  ensuring average O(1) time and O(h) space.
    private final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        pushLeftBranch(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeftBranch(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeftBranch(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
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
