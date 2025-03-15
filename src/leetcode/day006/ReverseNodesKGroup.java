package leetcode.day006;

/**
 * 25. Reverse Nodes in k-Group
 *
 * @author Created by sunjy on 3/12/25
 */
public class ReverseNodesKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy, next = dummy, prev = dummy;
        int count = 0;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        while (count >= k) {
            current = prev.next;
            next = current.next;
            for (int i = 1; i < k; i++) {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            prev = current;
            count -= k;
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
