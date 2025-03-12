package leetcode.day005;

/**
 * 287. Find the Duplicate Number
 *
 * @author Created by sunjy on 3/11/25
 */
public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

}
