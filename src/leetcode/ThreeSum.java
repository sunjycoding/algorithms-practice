package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 *
 * @author Created by sunjy on 4/17/25
 */
public class ThreeSum {

    //  I sort the array first, then fix one number nums[i],
    //  and use a two-pointer approach to find two numbers to the right such that their sum is -nums[i].
    //  I skip duplicates to avoid repeated triplets.

    //  Time O(n^2)
    //  Space O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

}
