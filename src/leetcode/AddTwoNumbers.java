package leetcode;

/**
 * 2. Add Two Numbers
 *
 * @author Created by sunjy on 4/18/25
 */
public class AddTwoNumbers {

    //  I use a dummy head to build the result list and maintain a carry to track carryover.
    //  At each step, I sum the two digits and the carry, then update the current node and move forward.
    //  The loop continues until both lists and carry are handled.

    //  Time O(max(m, n))
    //  Space O(max(m, n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyHead.next;
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
