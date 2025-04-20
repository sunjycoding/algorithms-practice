package leetcode;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * @author Created by sunjy on 4/19/25
 */
public class FindFirstLastPositionElementSortedArray {

    //  I use a binary search to find the first index
    //  where the value is greater than or equal to target (lower bound).
    //  For the right boundary, I search for target + 1 and subtract one.

    //  Time O(logn) + O(logn) = O(logn)
    //  O(1)
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findFirstPosition(nums, target);
        int rightIndex = findFirstPosition(nums, target + 1) - 1;

        if (leftIndex <= rightIndex && leftIndex < nums.length && nums[leftIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        } else {
            return new int[]{-1, -1};
        }
    }

    public int findFirstPosition(int[] nums, int target) {
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
