package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 *
 * @author Created by sunjy on 4/17/25
 */
public class ContainsDuplicateII {

    //  I use a HashSet as a sliding window of size k.
    //  If I see a duplicate inside the window, I return true.
    //  Otherwise, I remove the element that just moved out of the window.

    //  Time O(n)
    //  Space O(min(n, k))
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }

}
