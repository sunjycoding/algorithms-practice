package leetcode.day009;

/**
 * 153. Find Minimum in Rotated Sorted Array
 *
 * @author Created by sunjy on 4/4/25
 */
public class FindMinimumRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }

}
