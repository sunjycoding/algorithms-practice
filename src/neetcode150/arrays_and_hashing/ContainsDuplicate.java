package neetcode150.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Created by sunjy on 4/26/25
 */
public class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
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
