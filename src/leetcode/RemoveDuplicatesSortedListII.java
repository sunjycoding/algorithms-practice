package leetcode;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * @author Created by sunjy on 4/18/25
 */
public class RemoveDuplicatesSortedListII {

    //  I use a dummy node to simplify edge cases.
    //  If I detect two adjacent nodes with the same value, I keep skipping all nodes with that value.
    //  Otherwise, I just move forward. All operations are done in-place.

    //  Time O(n)
    //  Space O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int val = current.next.val;
                while (current.next != null && current.next.val == val) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }

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
