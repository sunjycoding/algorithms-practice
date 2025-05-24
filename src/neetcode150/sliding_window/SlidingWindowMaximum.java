package neetcode150.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Created by sunjy on 5/3/25
 */
public class SlidingWindowMaximum {

    //  Can the input array be empty? Can k be zero?
    //  Is it guaranteed that k <= nums.length?
    //  Should I return the maximum value for every sliding window of size k?

    //  I'm using a monotonic decreasing deque,
    //  where I store indices instead of values.
    //  For each new index i, I first remove indices that are outside the window (i - k + 1).
    //  Then, I remove all indices from the back where the value is less than nums[i],
    //  since they can't be maximum anymore.
    //  Finally, I push i into the deque.
    //  The front of the deque always gives the index of the maximum in the current window.

    //  Time O(n)
    //  Space O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
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
