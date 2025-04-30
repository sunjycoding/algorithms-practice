package neetcode150.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 4/29/25
 */
public class MergeKSortedLinkedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode listNode : lists) {
            minHeap.offer(listNode);
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            current.next = top;
            if (top.next != null) {
                minHeap.offer(top.next);
            }
            current = current.next;
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
