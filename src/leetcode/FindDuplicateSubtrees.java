package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees
 *
 * @author Created by sunjy on 4/25/25
 */
public class FindDuplicateSubtrees {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String left = traverse(node.left);
        String right = traverse(node.right);
        String serial = node.val + "," + left + "," + right;
        int count = map.getOrDefault(serial, 0);
        if (count == 1) {
            res.add(node);
        }
        map.put(serial, count + 1);
        return serial;
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
