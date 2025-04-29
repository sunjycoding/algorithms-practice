package leetcode;

import java.util.Arrays;

/**
 * 2962. Count Subarrays Where Max Element Appears at Least K Times
 *
 * @author Created by sunjy on 4/29/25
 */
public class CountSubarraysWhereMaxElementAppearsLeastKTimes {

    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                count++;
            }
            while (left <= right && count >= k) {
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
            ans += left;

        }
        return ans;
    }

}
