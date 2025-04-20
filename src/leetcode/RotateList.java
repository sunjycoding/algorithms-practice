package leetcode;

/**
 * 61. Rotate List
 *
 * @author Created by sunjy on 4/18/25
 */
public class RotateList {

    //  I first traverse the list to get its length n,
    //  then compute k % n as the actual rotation steps.
    //  I locate the new tail at the (n - k)th node,
    //  break the list there, and reconnect the original tail to the head.

    //  Time O(n)
    //  Space O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k = k % n;
        if (k == 0) {
            return head;
        }

        int stepsToNewTail = n - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
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
