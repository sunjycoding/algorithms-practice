package neetcode150.binary_search;

/**
 * @author Created by sunjy on 5/3/25
 */
public class SearchRotatedSortedArray {

    //  Does the array contain duplicates?
    //  Is the array guaranteed to be rotated?
    //  Should I return -1 if the target is not found?

    //  I use a modified binary search.
    //  Although the array is rotated, one side is always sorted.
    //  I check if the target lies in that sorted half and adjust the search range accordingly.

    //  Time O(log n)
    //  Space O(1)
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
