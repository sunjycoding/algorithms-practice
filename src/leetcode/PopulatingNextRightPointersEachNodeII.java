package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. Populating Next Right Pointers in Each Node II
 *
 * @author Created by sunjy on 4/20/25
 */
public class PopulatingNextRightPointersEachNodeII {

    //  I use BFS level-order traversal.
    //  For each level, I link each node’s next pointer to the node to its right.
    //  The last node points to null. I use prevNode to track the previous node in the same level.

    //  Time O(n)
    //  Space O(n)
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node prevNode = null;
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (i == levelSize - 1) {
                    currentNode.next = null;
                }
                if (prevNode != null) {
                    prevNode.next = currentNode;
                }
                prevNode = currentNode;
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
