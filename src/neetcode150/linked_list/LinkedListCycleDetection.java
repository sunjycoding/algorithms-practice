package neetcode150.linked_list;

/**
 * @author Created by sunjy on 5/3/25
 */
public class LinkedListCycleDetection {

    //  Can the input list be empty? Could a single-node list form a cycle?
    //  Do we only need to detect if a cycle exists, or also return the start of the cycle?

    //  I use the fast and slow pointer technique.
    //  slow moves one step at a time, fast moves two.
    //  If there is a cycle, they will eventually meet inside the loop.
    //  If not, fast will reach the end first (null).

    //  Time O(n)
    //  Space O(1)
    public boolean hasCycle(ListNode head) {
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
