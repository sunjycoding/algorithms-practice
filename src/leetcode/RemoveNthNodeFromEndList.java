package leetcode;

/**
 * 19. Remove Nth Node From End of List
 *
 * @author Created by sunjy on 4/18/25
 */
public class RemoveNthNodeFromEndList {

    //  I use two pointers: fast and slow.
    //  Fast advances n steps ahead, then both move together.
    //  When fast reaches the end, slow is right before the node to be removed.
    //  We remove slow.next.

    //  Time O(n)
    //  Space O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
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
