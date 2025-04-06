package leetcode.day010;

/**
 * 167. Two Sum II - Input Array Is Sorted
 *
 * @author Created by sunjy on 4/5/25
 */
public class TwoSumIIInputArrayIsSorted {

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
        throw new RuntimeException();
    }

}
