package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 *
 * @author Created by sunjy on 4/17/25
 */
public class HappyNumber {

    //  I keep replacing n with the sum of squares of its digits.
    //  If a number repeats, that means we've entered a cycle — return false.
    //  If we reach 1, it's a happy number.

    //  Time O(logn)
    //  Space O(logn)
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            n = getNext(n);
        }
        return true;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

}
