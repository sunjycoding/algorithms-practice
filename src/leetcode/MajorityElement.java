package leetcode;

/**
 * 169. Majority Element
 *
 * @author Created by sunjy on 4/16/25
 */
public class MajorityElement {

    //  I use the Boyer-Moore Voting Algorithm.
    //  I keep a candidate and a count.
    //  If count == 0, I pick the current number as the new candidate.
    //  If the current number equals the candidate, I increment count. Otherwise, decrement.
    //  Since the majority element appears more than half the time,
    //  it will survive the canceling process and remain as the final candidate.

    //  Time O(n)
    //  Space O(1)
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

}
