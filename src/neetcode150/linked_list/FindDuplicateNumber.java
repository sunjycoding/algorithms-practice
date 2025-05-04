package neetcode150.linked_list;

/**
 * @author Created by sunjy on 5/3/25
 */
public class FindDuplicateNumber {

    //  Is there only one duplicate number?
    //  Are we allowed to modify the input array?
    //  Is the input always valid? Will the array always have at least two elements?

    //  I treat the array as a linked list where each value nums[i] is a pointer to the next index.
    //  The duplicate causes a cycle.
    //  I use Floyd’s Tortoise and Hare algorithm
    //  to detect the cycle and find its entry point, which is the duplicate.

    //  Time O(n)
    //  Space O(1)
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
        return slow;
    }

}
