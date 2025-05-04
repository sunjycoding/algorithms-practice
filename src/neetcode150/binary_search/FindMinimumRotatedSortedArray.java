package neetcode150.binary_search;

/**
 * @author Created by sunjy on 5/3/25
 */
public class FindMinimumRotatedSortedArray {

    //  Is the array strictly ascending before rotation?
    //  Can the array contain duplicate values?
    //  Is the array guaranteed to be non-empty?

    //  Since the array is a rotated sorted array, there's a pivot where the order breaks.
    //  I use binary search to find that pivot by comparing nums[mid] to nums[nums.length - 1],
    //  and narrow the range accordingly.

    //  Time O(logn)
    //  Space O(1)
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
