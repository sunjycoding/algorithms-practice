package neetcode150.linked_list;

/**
 * @author Created by sunjy on 5/4/25
 */
public class AddTwoNumbers {

    //  Can either input list be null?
    //  Are both lists guaranteed to be non-null? Can the result be longer than both?
    //  Are the digits stored in reverse order or normal order?

    //  I traverse both input lists with two pointers,
    //  add corresponding digits and handle carry.
    //  I use a dummy node to build the result list.
    //  If one list ends early, I treat it as 0.
    //  If there's a remaining carry at the end, I append a new node.

    //  Time O(max(m, n))
    //  Space O(max(m, n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
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
