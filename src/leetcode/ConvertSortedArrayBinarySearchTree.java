package leetcode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * @author Created by sunjy on 4/21/25
 */
public class ConvertSortedArrayBinarySearchTree {

    //  I use recursion to build a height-balanced BST.
    //  For each subarray, I pick the middle element as the root and recursively build the left and right subtrees.
    //  Since the array is split evenly, the tree remains balanced.

    //  Time O(n)
    //  Space O(logn) ~ O(n)
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);

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
