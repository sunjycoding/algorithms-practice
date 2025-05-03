package neetcode150.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Created by sunjy on 5/2/25
 */
public class ThreeSum {

    //  Can the input array be null or have fewer than 3 elements?
    //  Can the array contain duplicate numbers?
    //  Should I avoid returning duplicate triplets?
    //  Is the order of triplets or the overall result important?

    //  I first sort the array.
    //  Then for each number nums[i],
    //  I use two pointers from i+1 and the end to find pairs whose sum is -nums[i].
    //  After finding a valid triplet, I skip over duplicates to avoid repeating the same combination.

    //  Time O(n^2)
    //  Space O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }

}
