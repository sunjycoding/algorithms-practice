package leetcode;

/**
 * 25. Reverse Nodes in k-Group
 *
 * @author Created by sunjy on 4/18/25
 */
public class ReverseNodesKGroup {

    //  I use a dummy node before head.
    //  For each k-group, I check if there are k nodes.
    //  If yes, I reverse them and reconnect. I use three pointers: prev, start, and end.

    //  Time O(n)
    //  Space O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) {
                break;
            }

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            kth.next = null;

            reverse(groupStart);

            prevGroupEnd.next = kth;
            groupStart.next = nextGroupStart;

            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }

    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
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
