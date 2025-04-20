package leetcode;

/**
 * 138. Copy List with Random Pointer
 *
 * @author Created by sunjy on 4/18/25
 */
public class CopyListRandomPointer {

    //  I use a 3-step approach:
    //  Interleave copied nodes after original ones;
    //  Use original.random.next to assign copy.random;
    //  Finally, split the list into original and cloned.
    //  This runs in O(n) time and uses O(1) extra space.

    //  Time O(n)
    //  Space O(1)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        Node dummyHead = new Node(0);
        Node copyCurrent = dummyHead;
        current = head;
        while (current != null) {
            copyCurrent.next = current.next;
            copyCurrent = copyCurrent.next;
            current.next = current.next.next;
            current = current.next;
        }

        return dummyHead.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
