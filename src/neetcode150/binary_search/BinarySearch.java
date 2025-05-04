package neetcode150.binary_search;

/**
 * @author Created by sunjy on 5/3/25
 */
public class BinarySearch {

    //  Is the array sorted in ascending order?
    //  Can the array contain duplicates? Should we return any index, or the first/last occurrence?
    //  Can the array be empty?

    //  I use binary search: each time I calculate the middle index mid.
    //  If nums[mid] is less than the target, I search the right half;
    //  if greater, I search the left half. If equal, I return the index.

    //  Time O(log n)
    //  Space O(1)
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
