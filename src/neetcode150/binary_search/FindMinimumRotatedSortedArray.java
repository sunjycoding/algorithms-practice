package neetcode150.binary_search;

/**
 * @author Created by sunjy on 5/3/25
 */
public class FindMinimumRotatedSortedArray {

    //  Is the array strictly ascending before rotation?
    //  Can the array contain duplicate values?
    //  Is the array guaranteed to be non-empty?

    //  I used binary search to find the minimum in a rotated sorted array.
    //  By comparing nums[mid] and nums[right], I can determine where the minimum lies.
    //  If nums[mid] > nums[right], the minimum must be to the right.
    //  Otherwise, it’s to the left, possibly including mid.

    //  Time O(logn)
    //  Space O(1)
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

}
