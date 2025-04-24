package leetcode;

/**
 * 141. Linked List Cycle
 *
 * @author Created by sunjy on 4/18/25
 */
public class LinkedListCycle {

    //  I use two pointers: a slow one that moves one step,
    //  and a fast one that moves two steps.
    //  If there's a cycle, the fast pointer will eventually meet the slow one.
    //  If the fast pointer hits null, the list has no cycle.

    //  Time O(n)
    //  Space O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}