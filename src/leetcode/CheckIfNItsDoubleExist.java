package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Check If N and Its Double Exist
 *
 * @author Created by sunjy on 4/24/25
 */
public class CheckIfNItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

}
