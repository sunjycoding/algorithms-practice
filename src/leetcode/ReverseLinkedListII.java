package leetcode;

/**
 * 92. Reverse Linked List II
 *
 * @author Created by sunjy on 4/18/25
 */
public class ReverseLinkedListII {

    //  I find the node before the reversal (pre),
    //  then reverse right - left + 1 nodes using pointers.
    //  After reversing, I reconnect pre.next to prev (new head),
    //  and reverseStart.next to curr (next node after reversal).

    //  Time O(n)
    //  Space O(1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode reverseStart = pre.next;
        ListNode current = reverseStart;
        ListNode prev = null;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        pre.next = prev;
        reverseStart.next = current;

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
