package leetcode;

/**
 * 724. Find Pivot Index
 *
 * @author Created by sunjy on 4/24/25
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

}
