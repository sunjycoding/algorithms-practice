package neetcode150.linked_list;

/**
 * @author Created by sunjy on 5/4/25
 */
public class CopyLinkedListRandomPointer {

    //  Can the input list be null?
    //  Can a node's random pointer point to null or itself?
    //  Are we allowed to use extra data structures like HashMap?

    //  I use a three-pass approach:
    //  1. Copy each node and insert it after the original;
    //  2. Set up the copied random pointers;
    //  3. Separate the two lists.

    //  Time O(n)
    //  Space O(1)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        current = head;
        Node newHead = head.next;
        while (current != null) {
            Node copy = current.next;
            current.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            current = current.next;
        }
        return newHead;
    }

    public static class Node {
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
