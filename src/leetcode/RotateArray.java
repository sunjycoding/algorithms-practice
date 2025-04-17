package leetcode;

/**
 * 189. Rotate Array
 *
 * @author Created by sunjy on 4/16/25
 */
public class RotateArray {

    //  I use the three-step reverse method:
    //  First, reverse the entire array.
    //  Then reverse the first k elements.
    //  Finally, reverse the rest (n-k elements).
    //  This effectively rotates the array to the right by k positions, and it’s done in-place.

    //  Time O(n)
    //  Space O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
