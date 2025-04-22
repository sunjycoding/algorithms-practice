package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 *
 * @author Created by sunjy on 4/21/25
 */
public class MergeKSortedLists {

    //  I use a min-heap to maintain the smallest current node among the k lists.
    //  Each time I extract the smallest node and append it to the result,
    //  then push its next node into the heap.
    //  This keeps the overall order. Time complexity is O(N log k).

    //  Time O(nlogk)
    //  Space O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                minHeap.offer(listNode);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
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
