package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 *
 * @author Created by sunjy on 4/25/25
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
