package neetcode150.binary_search;

/**
 * @author Created by sunjy on 4/26/25
 */
public class FindMinimumRotatedSortedArray {

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
