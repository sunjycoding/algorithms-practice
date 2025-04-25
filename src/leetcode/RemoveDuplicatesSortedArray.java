package leetcode;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * @author Created by sunjy on 4/16/25
 */
public class RemoveDuplicatesSortedArray {

    //  I use two pointers. slow keeps track of the last unique element,
    //  and fast scans the array. When we find a new unique element,
    //  we move it to slow + 1. At the end, slow + 1 gives us the length of the deduplicated array.

    //  Time O(n)
    //  Space O(1)
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

}
