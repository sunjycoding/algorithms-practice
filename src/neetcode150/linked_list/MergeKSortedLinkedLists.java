package neetcode150.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 5/4/25
 */
public class MergeKSortedLinkedLists {

    //  Can some of the input lists be null?
    //  What are the expected total number of nodes and the value of k?
    //  Are we allowed to reuse the original nodes or must we create new ones?

    //  I use a min-heap to perform an efficient k-way merge.
    //  I first push the head node of each list into the heap.
    //  Then I continuously pop the smallest node,
    //  append it to the result list,
    //  and if that node has a next, I push it into the heap.

    //  O(n log k)
    //  O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode listNode : lists) {
            minHeap.offer(listNode);
        }
        while (!minHeap.isEmpty()) {
            ListNode listNode = minHeap.poll();
            current.next = listNode;
            current = current.next;
            if (listNode.next != null) {
                minHeap.offer(listNode.next);
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
