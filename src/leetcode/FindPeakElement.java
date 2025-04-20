package leetcode;

/**
 * 162. Find Peak Element
 *
 * @author Created by sunjy on 4/19/25
 */
public class FindPeakElement {

    //  I use binary search to find a peak.
    //  If nums[mid] < nums[mid+1], the peak must be on the right; otherwise it’s on the left or at mid.
    //  We shrink the interval until left + 1 = right.

    //  O(logn)
    //  O(1)
    public int findPeakElement(int[] nums) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int leftVal = mid > 0 ? nums[mid - 1] : Integer.MIN_VALUE;
            int rightVal = mid < nums.length - 1 ? nums[mid + 1] : Integer.MIN_VALUE;
            if (nums[mid] > leftVal && nums[mid] > rightVal) {
                return mid;
            }
            if (rightVal > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
