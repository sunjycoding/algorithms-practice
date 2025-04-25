package leetcode;

import java.util.Arrays;

/**
 * 414. Third Maximum Number
 *
 * @author Created by sunjy on 4/24/25
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int result = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                count++;
                if (count == 3) {
                    result = nums[i];
                }
            }
        }
        return result;
    }

}
