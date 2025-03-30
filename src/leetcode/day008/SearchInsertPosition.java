package leetcode.day008;

/**
 * 35. Search Insert Position
 *
 * @author Created by sunjy on 3/28/25
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return right;
    }

}
