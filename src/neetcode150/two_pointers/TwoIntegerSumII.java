package neetcode150.two_pointers;

/**
 * @author Created by sunjy on 5/2/25
 */
public class TwoIntegerSumII {

    //  Is the input array guaranteed to be sorted?
    //  Is it guaranteed that exactly one solution exists?
    //  Should I return 0-based or 1-based indices?

    //  I use two pointers:
    //  one starting from the left and the other from the right.
    //  If the sum is less than the target, I move the left pointer forward;
    //  if greater, I move the right pointer back.
    //  Since the array is sorted, this guarantees we find the answer in linear time.

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
        return null;
    }

}
