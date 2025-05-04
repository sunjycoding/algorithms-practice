package neetcode150.linked_list;

/**
 * @author Created by sunjy on 5/3/25
 */
public class ReverseLinkedList {

    //  Can the input list be null?
    //  Should the reversal be in-place, or can I use extra space?

    //  I use three pointers to reverse the list step by step:
    //  prev tracks the previous node, current is the node being processed,
    //  and next keeps the next node so we don’t lose the reference.
    //  I update current.next = prev, and then move all pointers forward.
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
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
