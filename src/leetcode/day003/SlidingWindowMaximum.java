package leetcode.day003;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum
 *
 * @author Created by sunjy on 3/6/25
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int length = nums.length;
        int[] result = new int[length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

}
