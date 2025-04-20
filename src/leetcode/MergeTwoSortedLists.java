package leetcode;

/**
 * 21. Merge Two Sorted Lists
 *
 * @author Created by sunjy on 4/18/25
 */
public class MergeTwoSortedLists {

    //  I use a dummy node to simplify the head pointer. I compare values from both lists,
    //  append the smaller one to the result, and advance the pointer.
    //  Once one list is done, I append the remaining part of the other list directly.

    //  Time O(m + n)
    //  Space O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
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
