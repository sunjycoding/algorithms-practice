package leetcode;

import java.util.Arrays;

/**
 * @author Created by sunjy on 4/16/25
 */
public class A {

    public static void main(String[] args) {
        RemoveDuplicatesSortedArray removeDuplicatesSortedArray = new RemoveDuplicatesSortedArray();
        int[] nums = new int[]{1, 1, 2};
        removeDuplicatesSortedArray.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

}
