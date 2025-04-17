package leetcode;

/**
 * 80. Remove Duplicates from Sorted Array II
 *
 * @author Created by sunjy on 4/16/25
 */
public class RemoveDuplicatesSortedArrayII {

    //  I'll use the two-pointer technique.
    //  The key idea is to allow at most two duplicates. So I start scanning from index 2.
    //  If nums[fast] != nums[slow - 2], it means the current number hasn't appeared more than twice —
    //  we can safely copy it to nums[slow].
    //  This way, we preserve up to two copies of each number.

    //  Time: O(n)
    //  Space: O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

}
