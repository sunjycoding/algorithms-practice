package leetcode;

/**
 * 27. Remove Element
 *
 * @author Created by sunjy on 4/16/25
 */
public class RemoveElement {

    //  I use a two-pointer approach.
    //  fast scans through the array, and slow tracks the position to write the next valid number.
    //  If nums[fast] != val, I assign nums[slow] = nums[fast] and increment slow.
    //  At the end, slow gives the new length.

    //  Time O(n)
    //  Space O(1)
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

}
