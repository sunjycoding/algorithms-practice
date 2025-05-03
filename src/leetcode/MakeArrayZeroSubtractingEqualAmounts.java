package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2357. Make Array Zero by Subtracting Equal Amounts
 *
 * @author Created by sunjy on 5/2/25
 */
public class MakeArrayZeroSubtractingEqualAmounts {

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }
        return set.size();
    }

}
