package leetcode;

/**
 * 153. Find Minimum in Rotated Sorted Array
 *
 * @author Created by sunjy on 4/19/25
 */
public class FindMinimumRotatedSortedArray {

    //  I apply binary search on the rotated sorted array.
    //  By comparing nums[mid] and nums[nums.length - 1], I decide whether the minimum lies on the left or right.
    //  Eventually, the search converges to the smallest element.

    //  Time O(log n)
    //  Space O(1)
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
