package leetcode.day001;

/**
 * 2413. Smallest Even Multiple
 *
 * @author Created by sunjy on 3/1/25
 */
public class SmallestEvenMultiple {

    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }
        return n * 2;
    }

}
