package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 *
 * @author Created by sunjy on 4/25/25
 */
public class IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] result = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            result[i] = num;
            i++;
        }
        return result;
    }

}
