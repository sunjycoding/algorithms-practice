package neetcode150.linked_list;

/**
 * @author Created by sunjy on 5/3/25
 */
public class MergeTwoSortedLinkedLists {

    //  Are both input lists already sorted in ascending order?
    //  Can we modify the original nodes, or should we create new ones?
    //  Can either of the input lists be null?

    //  I use a dummy node to simplify the head tracking,
    //  and a current pointer to build the merged list.
    //  At each step, I compare the heads of both lists
    //  and append the smaller one.
    //  Once one list is exhausted, I append the remaining part of the other.

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
        current.next = list1 == null ? list2 : list1;
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
