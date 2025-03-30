package leetcode.day008;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * @author Created by sunjy on 3/28/25
 */
public class FindFirstLastPositionElementSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findFirstGreaterEqual(nums, target);
        int rightIndex = findFirstGreaterEqual(nums, target + 1) - 1;

        if (leftIndex <= rightIndex && leftIndex < nums.length && nums[leftIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int findFirstGreaterEqual(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
