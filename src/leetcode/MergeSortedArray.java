package leetcode;

/**
 * 88. Merge Sorted Array
 *
 * @author Created by sunjy on 4/16/25
 */
public class MergeSortedArray {

    //  We can merge from the back to the front using three pointers.
    //  p1 starts at the last valid element in nums1, p2 at the end of nums2,
    //  and p at the end of the total length of nums1.
    //  We compare from the back and place the larger one at the end.
    //  This way we avoid extra space.

    //  Time O(m + n)
    //  Space O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

}
