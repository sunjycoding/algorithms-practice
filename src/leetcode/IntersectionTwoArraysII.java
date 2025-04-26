package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 *
 * @author Created by sunjy on 4/25/25
 */
public class IntersectionTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums1) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer freq = hashMap.get(num);
            if (freq != null && freq > 0) {
                list.add(num);
                freq--;
                hashMap.put(num, freq);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i] = num;
            i++;
        }
        return result;
    }

}
