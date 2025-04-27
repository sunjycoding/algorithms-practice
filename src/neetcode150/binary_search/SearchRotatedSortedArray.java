package neetcode150.binary_search;

/**
 * @author Created by sunjy on 4/26/25
 */
public class SearchRotatedSortedArray {

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
