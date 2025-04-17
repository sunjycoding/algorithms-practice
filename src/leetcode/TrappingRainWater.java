package leetcode;

/**
 * 42. Trapping Rain Water
 *
 * @author Created by sunjy on 4/16/25
 */
public class TrappingRainWater {

    //  I create two arrays:
    //  preMax[i] stores the highest bar to the left (including current),
    //  sufMax[i] stores the highest bar to the right (including current).
    //  At each index, the trapped water is min(preMax[i], sufMax[i]) - height[i].
    //  We sum it across all positions to get the total.

    //  Time O(n)
    //  Space O(n)
    public int trap(int[] height) {
        int length = height.length;
        int[] preMax = new int[length];
        int[] sufMax = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, height[i]);
            preMax[i] = max;
        }
        max = 0;
        for (int i = length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            sufMax[i] = max;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return result;
    }

}
