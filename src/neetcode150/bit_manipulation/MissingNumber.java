package neetcode150.bit_manipulation;

/**
 * @author Created by sunjy on 4/27/25
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : nums) {
            arrSum += num;
        }
        return total - arrSum;
    }

}
