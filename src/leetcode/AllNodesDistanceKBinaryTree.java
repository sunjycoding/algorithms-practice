package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 863. All Nodes Distance K in Binary Tree
 *
 * @author Created by sunjy on 5/2/25
 */
public class AllNodesDistanceKBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);

        int currentDistance = 0;

        while (!queue.isEmpty()) {
            if (currentDistance == k) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode neighbor : getNeighbors(node, parentMap)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            currentDistance++;
        }

        List<Integer> res = new ArrayList<>();
        for (TreeNode node : queue) {
            res.add(node.val);
        }
        return res;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        parentMap.put(node, parent);
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }

    private List<TreeNode> getNeighbors(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        List<TreeNode> neighbors = new ArrayList<>();
        if (node.left != null) {
            neighbors.add(node.left);
        }
        if (node.right != null) {
            neighbors.add(node.right);
        }
        if (parentMap.get(node) != null) {
            neighbors.add(parentMap.get(node));
        }
        return neighbors;
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
