package leetcode.day001;

/**
 * 1470. Shuffle the Array
 *
 * @author Created by sunjy on 3/1/25
 */
public class ShuffleArray {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }

}
