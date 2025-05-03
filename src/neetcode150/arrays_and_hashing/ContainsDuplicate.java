package neetcode150.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Created by sunjy on 5/2/25
 */
public class ContainsDuplicate {

    //  Can the input array be null?
    //  Can the array be empty?

    //  I'm using a HashSet to keep track of seen numbers.
    //  If I find a duplicate while iterating, I return true.

    //  Time O(n)
    //  Space O(n)
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
