package leetcode;

/**
 * 35. Search Insert Position
 *
 * @author Created by sunjy on 4/19/25
 */
public class SearchInsertPosition {

    //  I used a generalized binary search template with left = -1 and right = n.
    //  This ensures that when the loop ends, left + 1 gives the exact insert position for target.

    //  Time O(logn)
    //  Space O(1)
    public int searchInsert(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid;
            } else {
                return mid;
            }
        }
        return left + 1;
    }

}
