package leetcode;

/**
 * 86. Partition List
 *
 * @author Created by sunjy on 4/18/25
 */
public class PartitionList {

    //  I create two lists: one for nodes less than x, another for nodes greater or equal.
    //  As I traverse the original list, I partition nodes into these two lists and finally connect them.
    //  This keeps the relative order and runs in O(n) time with O(1) space.

    //  Time O(n)
    //  Space O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
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
