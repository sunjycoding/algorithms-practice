package neetcode150.linked_list;

/**
 * @author Created by sunjy on 5/3/25
 */
public class RemoveNodeFromEndLinkedList {

    //  Can the list be empty? Is n always guaranteed to be valid?
    //  Can n equal the list length, meaning we remove the head?

    //  I use two pointers.
    //  First, I move the fast pointer n steps ahead.
    //  Then I start slow from a dummy node and move both pointers until fast reaches the end.
    //  At that point, slow is right before the node to delete.
    //  I update slow.next to skip the target node.

    //  Time O(n)
    //  Space O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
