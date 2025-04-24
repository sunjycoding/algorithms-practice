package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2799. Count Complete Subarrays in an Array
 *
 * @author Created by sunjy on 4/23/25
 */
public class CountCompleteSubarraysArray {

    //  I first count the number of distinct elements k in the array.
    //  Then I use a sliding window to count all subarrays
    //  whose distinct element count is less than k.
    //  Finally, I subtract that from the total number of subarrays
    //  to get the number of complete ones.

    //  Time O(n)
    //  Space O(k)
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distinctSet = new HashSet<>();
        for (int num : nums) {
            distinctSet.add(num);
        }
        int k = distinctSet.size();

        int incomplete = 0;
        Map<Integer, Integer> windowMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            windowMap.put(nums[right], windowMap.getOrDefault(nums[right], 0) + 1);

            while (windowMap.size() == k) {
                windowMap.put(nums[left], windowMap.get(nums[left]) - 1);
                if (windowMap.get(nums[left]) == 0) {
                    windowMap.remove(nums[left]);
                }
                left++;
            }

            incomplete += (right - left + 1);
        }

        int total = nums.length * (nums.length + 1) / 2;
        return total - incomplete;
    }

}
