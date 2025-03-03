package neetcode.day001;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate
 *
 * @author Created by sunjy on 3/2/25
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
