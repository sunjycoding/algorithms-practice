package leetcode;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number
 *
 * @author Created by sunjy on 5/16/25
 */
public class ValidTriangleNumber {

    //  I sort the array first, then fix the third side c.
    //  I use two pointers from the start and end of the remaining array to find pairs where a + b > c.
    //  Since the array is sorted, when nums[i] + nums[j] > nums[k],
    //  all elements between i and j form valid triangles.

    //  Time O(n^2)
    //  Space O(1)
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }

}
