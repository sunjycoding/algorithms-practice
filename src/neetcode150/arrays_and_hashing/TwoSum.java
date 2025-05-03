package neetcode150.arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by sunjy on 5/2/25
 */
public class TwoSum {

    //  Can the input array be null or empty?
    //  Can the array contain duplicate numbers?
    //  Is it guaranteed that there is exactly one solution? Or could there be no solution?
    //  If there are multiple valid solutions, which one should I return?

    //  I use a HashMap to store each number and its index as I iterate.
    //  For the current number, I calculate the complement (target - nums[i]).
    //  If the complement exists in the map, we return the indices.

    //  Time O(n)
    //  Space O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int j = map.get(complement);
                if (i < j) {
                    return new int[]{i, j};
                } else {
                    return new int[]{j, i};
                }
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
