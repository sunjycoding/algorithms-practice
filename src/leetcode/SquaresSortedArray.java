package leetcode;

/**
 * 977. Squares of a Sorted Array
 *
 * @author Created by sunjy on 4/24/25
 */
public class SquaresSortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int i = n - 1;

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq > rightSq) {
                result[i] = leftSq;
                i--;
                left++;
            } else {
                result[i] = rightSq;
                i--;
                right--;
            }
        }
        return result;
    }

}
