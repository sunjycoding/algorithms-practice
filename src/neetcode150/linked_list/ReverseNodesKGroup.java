package neetcode150.linked_list;

/**
 * @author Created by sunjy on 5/4/25
 */
public class ReverseNodesKGroup {

    //  length ≥ k ?
    //  Can I modify the linkedlist?
    //  Should I keep the order if there's no k nodes left?
    
    //  I used a dummy node to simplify edge cases.
    //  For each group of k nodes,
    //  I reverse them in-place using a three-pointer approach:
    //  current, next, and prev.
    //  After reversal, I rewire the pointers to connect the reversed group back to the list.
    //  I use a helper getKth() to check if there’s a full group of k nodes left

    //  Time O(n)
    //  Space O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            ListNode prev = kth.next;
            ListNode current = groupPrev.next;
            while (current != groupNext) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode listNode, int k) {
        while (listNode != null && k > 0) {
            listNode = listNode.next;
            k--;
        }
        return listNode;
    }

    private ListNode reverse(ListNode head) {
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
