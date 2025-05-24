package neetcode150.linked_list;

/**
 * @author Created by sunjy on 5/3/25
 */
public class ReorderLinkedList {

    //  Can the list be null or contain only 1-2 nodes?
    //  Are we allowed to modify the original list in place?

    //  I solve this in three steps:
    //  1. Find the middle using fast and slow pointers,
    //  2. Reverse the second half of the list,
    //  3. Merge the two halves alternately.
    //  The entire process is in-place with O(1) space.

    //  Time O(n)
    //  Space O(1)
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow.next);
        slow.next = null;
        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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
