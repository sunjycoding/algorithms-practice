package leetcode;

/**
 * 33. Search in Rotated Sorted Array
 *
 * @author Created by sunjy on 4/19/25
 */
public class SearchRotatedSortedArray {

    //  I use binary search and determine whether mid is in the sorted left or right part.
    //  If left part is sorted and target lies in it, move right; otherwise search right half.
    //  Finally check if mid equals the target.

    //  Time O(logn)
    //  Space O(1)
    public int search(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

}
