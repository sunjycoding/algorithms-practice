package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 *
 * @author Created by sunjy on 4/25/25
 */
public class FourSumII {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
        }
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -c - d;
                if (hashMap.containsKey(target)) {
                    count += hashMap.get(target);
                }
            }
        }
        return count;
    }

}
