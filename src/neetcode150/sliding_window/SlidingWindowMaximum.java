package neetcode150.sliding_window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Created by sunjy on 5/3/25
 */
public class SlidingWindowMaximum {

    //  Can the input array be empty? Can k be zero?
    //  Is it guaranteed that k <= nums.length?
    //  Should I return the maximum value for every sliding window of size k?

    //  I use a deque to store indices of elements that are candidates for the window's maximum.
    //  The deque is maintained in decreasing order of values.
    //  Before adding a new element,
    //  I remove elements from the back that are smaller than the current one — they can't be the max anymore.
    //  The front of the deque always holds the index of the current maximum.
    //  When the window slides, I remove elements from the front if they're out of range.

    //  Time O(n)
    //  Space O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && (deque.peekFirst() < i - k + 1)) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

}
