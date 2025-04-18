package leetcode;

/**
 * 167. Two Sum II - Input Array Is Sorted
 *
 * @author Created by sunjy on 4/17/25
 */
public class TwoSumIIInputArrayIsSorted {

    //  Since the array is sorted, I use a two-pointer approach.
    //  I start from both ends and move the pointers based on the sum compared to the target.
    //  It runs in O(n) time and uses constant space.

    //  Time O(n)
    //  Space O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }

}
